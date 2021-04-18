import java.sql.*;

public class DBConnection {
    private Connection connection;
    private final String url="jdbc:oracle:thin:@localhost:1521:xe";
    private final String user="student";
    private final String password="student";
    private DBConnection() {

        try {
            this.connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static DBConnection getDBConnection() {
        DBConnection dbConnection = new DBConnection();
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
