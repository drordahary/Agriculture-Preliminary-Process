import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TimeZone;

class MysqlCon{
    private final static String url="jdbc:mysql://localhost:3306/agricalture_database?serverTimezone=UTC&verifyServerCertificate=false&useSSL=true&requireSSL=true";

    public MysqlCon() {
    }

    public void connectToMySQL(){
        try{
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            TimeZone.setDefault(timeZone);

            //Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection(url,"root","root");

            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from cultivations where name = 'banana'");

            while(rs.next())
                System.out.print(rs.getString("water"));
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}