import java.sql.*;
import java.util.*;

class MysqlCon {

    public static Soil translatorSoil(int soil) {
        if (soil == 1)
            return Soil.Sandy;
        if (soil == 2)
            return Soil.Clay;
        if (soil == 3)
            return Soil.Peat;
        if (soil == 4)
            return Soil.Loam;
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

    public static GrowthType translatorType(int type) {
        if (type == 1)
            return GrowthType.Tree;
        if (type == 2)
            return GrowthType.Bush;
        if (type == 3)
            return GrowthType.land;
        return null;
    }

    private final static String url = "jdbc:mysql://localhost:3306/agriculture_database?serverTimezone=UTC&verifyServerCertificate=false&useSSL=true&requireSSL=true";
    private static LinkedList<Cultivation> Cultivations = new LinkedList<Cultivation>() {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Cultivation cultivation : Cultivations) {
                sb.append(cultivation.toString());
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
            ResultSet rs;
            int n;
            for (n = 1; stmt.executeQuery("select * from cultivations where cult_id=" + n).last(); n++);
            for (int i = 1; i <=n; i++) {
                rs = stmt.executeQuery("select * from cultivations where cult_id=" + i);
                while (rs.next()) {
                    int id = rs.getInt("cult_id");
                    String name = rs.getString("name");
                    int water = rs.getInt("water");
                    int temperature = rs.getInt("temperature");
                    Season season1 = translatorSeason(rs.getInt("season"));
                    Soil soil1 = translatorSoil(rs.getInt("soil_id"));
                    GrowthType growthType1 = translatorType(rs.getInt("growthtype_id"));
                    Cultivations.add(new Cultivation(id, name, water, temperature, season1, soil1, growthType1));
                }
            }
            con.close();
            System.out.println(Cultivations.toString());
        } catch (Exception e) {}
    }
}
