import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private static DBService instance;
    private static final String url = "jdbc:mysql://localhost:3306/lab8?serverTimezone = UTC";
    private static final String user = "root";
    private static final String password = "bigshark";
    private static Connection myConnection = null;
    public static Connection getConnection() {
        if (myConnection == null) {
            try {
                myConnection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return myConnection;
    }
    private DBService(){
    }
}