import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        String DSN = "jdbc:postgresql://localhost:5432/postgres?ssl=false";
        Connection conn;
        
        conn = DriverManager.getConnection(DSN, "postgres", "310542a");
    }
}