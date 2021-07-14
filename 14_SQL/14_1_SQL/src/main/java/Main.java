import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        sql();
    }
//for new commit
    private static void sql() {
        try {
            DriverManager.registerDriver(new Driver());
            String mysqlUrl = "jdbc:mysql://localhost/scillbox";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
            Statement stmt = con.createStatement();

            String sql = "SELECT course_name, count(*)/9 FROM scillbox.purchaselist group by course_name";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                double count = rs.getDouble("count(*)/9");
                String name = rs.getString("course_name");
                System.out.println(name + " - " + count);
            }
            con.close();

        } catch (Exception e) {
            //e.printStackTrace();
        }
    }


}
