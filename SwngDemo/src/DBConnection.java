import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    public static Connection dbconnect() {
        Connection con = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver"); // Updated driver class for MySQL Connector/J 8.x
            // Establish the connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_swing", "root", "123");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Database connection error", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "JDBC Driver not found", ex);
        }
        return con;
    }
}
