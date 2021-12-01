import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.Collection;

class MysqlCon{
    public Soil translatorSoil (String soil) {
        if (soil.equals("sandy"))
            return Soil.Sandy;
        if (soil.equals("clay"))
            return Soil.Clay;
        if (soil.equals("peat"))
            return Soil.Peat;
        return null;
    }
    public growthType translatorType (String type) {
        if (type.equals("tree"))
            return growthType.Tree;
        if (type.equals("bush"))
            return growthType.Bush;
        if (type.equals("land"))
            return growthType.land;
        return null;
    }

    private final static String url="jdbc:mysql://localhost:3306/agricalture_database?serverTimezone=UTC&verifyServerCertificate=false&useSSL=true&requireSSL=true";
    private static LinkedList <Cultivation> Cultivations = new LinkedList<>();
    public MysqlCon() {
    }

    public void connectToMySQL(){
        try{
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            TimeZone.setDefault(timeZone);

            Connection con=DriverManager.getConnection(url,"root","root");

            Statement stmt=con.createStatement();
            Statement stmt2=con.createStatement();
            Statement stmt3=con.createStatement();
            ResultSet rs;
            ResultSet soil;
            ResultSet growthType;
            for (int i=1; i<=2; i++){
                rs=stmt.executeQuery("select * from cultivations where cult_id="+i);
                soil = stmt2.executeQuery("select s.name from soils s inner join cultivations c on s.soil_id=c.soil_id where cult_id="+i);
                growthType = stmt3.executeQuery("select g.name from growthtypes g inner join cultivations c on g.growthType_id=c.soil_id where cult_id="+i);
                while(rs.next() && soil.next() && growthType.next())
                    Cultivations.add(new Cultivation(rs.getInt("cult_id"),rs.getString("name"), rs.getInt("water"),rs.getInt("temperature"),translatorSoil(soil.getString("name")), translatorType(growthType.getString("name"))));
                Cultivation cult = Cultivations.get(i-1);
                System.out.println(cult.toString());


           }
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}