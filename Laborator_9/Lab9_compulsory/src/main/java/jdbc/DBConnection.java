package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;
    private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String user = "student";
    private final String password = "student";
    private static DBConnection dbConnectionInstance;

    private DBConnection() {

        try {
            this.connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static DBConnection getDBConnection() {
        if (dbConnectionInstance == null) {
          dbConnectionInstance = new DBConnection();
        }
        return dbConnectionInstance;
    }

    public Connection getConnection() {
        return connection;
    }
}
