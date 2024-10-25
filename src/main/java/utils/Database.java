package utils;
import java.sql.*;

public class Database {
    public Connection c = null;
    Statement stmt = null;
    public Database(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(String.format("jdbc:sqlite:%s", Config.dbPath));
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void closeConnect() {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
