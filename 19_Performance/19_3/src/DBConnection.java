import java.sql.*;


public class DBConnection {

    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "admin";

    private static StringBuilder insertQuery = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "`count` INT NOT NULL, " +
                        "PRIMARY KEY(id))");
//                        "PRIMARY KEY(id), " +
//                        "UNIQUE  KEY name_date(name(50), birthDate))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public static void executeMultiInsert() throws SQLException {

        String sql = "INSERT INTO learn.voter_count(name, birthDate, `count`) " +
                "VALUES" + insertQuery.toString()
        + " ON DUPLICATE KEY UPDATE `count`=`count` + 1";
        DBConnection.getConnection().createStatement().execute(sql);

//        DriverManager.registerDriver(new Driver());
//        String mysqlUrl = "jdbc:mysql://localhost/learn";
//        Connection con = DriverManager.getConnection(mysqlUrl, "root", "admin");
//        Statement stmt = con.createStatement();
//
//        stmt.execute(sql);
//        con.close();

        //System.out.println(sql);


    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');

        insertQuery.append((insertQuery.length() == 0 ? "" : ",") +
                "('" + name + "', '" + birthDay + "', 1)");
        //System.out.println(insertQuery.length());

        if (insertQuery.length() > 150_000) {
            executeMultiInsert();
            insertQuery = new StringBuilder();
        }

    }

//    public static void printVoterCounts() throws SQLException {
//        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
//        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
////        while (rs.next()) {
////            System.out.println("\t" + rs.getString("name") + " (" +
////                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
////        }
//        rs.close();
//    }
}
