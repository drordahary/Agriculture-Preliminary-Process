package MySQLHandler;
import Agriculture.Area;
import Agriculture.Cultivation;
import Attributes.Range;
import Attributes.Season;
import Attributes.Soil;
import java.sql.*;
import java.util.*;

public class MysqlCon {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static Soil translatorSoil(int soil) {
        if (soil == 1)
            return Soil.Sandy;
        if (soil == 2)
            return Soil.Clay;
        if (soil == 3)
            return Soil.Peat;
        if (soil == 4)
            return Soil.Loam;
        if (soil == 5)
            return Soil.Basalt;
        if (soil == 6)
            return Soil.Tara_Rosa;
        if (soil == 7)
            return Soil.Las;
        return null;
    }

    public static Season translatorSeason(int season) {
        if (season == 1)
            return Season.winter;
        if (season == 2)
            return Season.summer;
        if (season == 3)
            return Season.all_year;
        return null;
    }

    private final static String url = "jdbc:mysql://localhost:3306/agriculture_database?serverTimezone=UTC&verifyServerCertificate=false&useSSL=true&requireSSL=true";
    private static final LinkedList<Cultivation> Cultivations = new LinkedList<Cultivation>() {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(YELLOW+"Cultivations list:\n\n"+RESET);
            for (Cultivation cultivation : Cultivations) {
                sb.append(cultivation.toString());
            }
            return sb.toString();
        }
    };
    private static final LinkedList<Area> Areas = new LinkedList<Area>() {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(YELLOW+"Areas list:\n\n"+RESET);
            for (Area area : Areas) {
                sb.append(area.toString());
            }
            return sb.toString();
        }
    };

    public MysqlCon() {
    }

    public void connectToMySQL() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            TimeZone.setDefault(timeZone);

            Connection con = DriverManager.getConnection(url, "root", "root");

            Statement stmt = con.createStatement();
            ResultSet cults;
            ResultSet areas;
            int nc;
            int na;
            for (nc = 1; stmt.executeQuery("select * from cultivations where cult_id=" + nc).last(); nc++);
            for (na = 1; stmt.executeQuery("select * from areas where area_id=" + na).last(); na++);
            for (int i = 1; i <=nc; i++) {
                cults = stmt.executeQuery("select * from cultivations where cult_id=" + i);
                while (cults.next()) {
                    int id = cults.getInt("cult_id");
                    String name = cults.getString("name");
                    int water = cults.getInt("water");
                    int temperature = cults.getInt("temperature");
                    Season season1 = translatorSeason(cults.getInt("season"));
                    Soil soil1 = translatorSoil(cults.getInt("soil_id"));
                    Cultivations.add(new Cultivation(id, name, water, temperature, season1, soil1));
                }
            }
                for (int i = 1; i <=na; i++) {
                areas = stmt.executeQuery("select * from areas where area_id=" + i);
                while (areas.next()) {
                    int id = areas.getInt("area_id");
                    String name = areas.getString("name");
                    Range summer_temperature = new Range (areas.getInt("summer_min_temp"), areas.getInt("summer_max_temp"));
                    Range winter_temperature = new Range (areas.getInt("winter_min_temp"), areas.getInt("winter_max_temp"));
                    Range precipitation = new Range (areas.getInt("min_precipitation"), areas.getInt("max_precipitation"));
                    Soil soil1 = translatorSoil(areas.getInt("soil_id"));
                    Areas.add(new Area(id, name, precipitation, summer_temperature, winter_temperature, soil1));
                }
            }

            con.close();
            System.out.println(Cultivations.toString());
            System.out.println(Areas.toString());
        }
        catch (Exception e) {}
    }
}
