import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddGenre {
    public static void insertGenre() throws SQLException {
        DBConnection dbConnection = DBConnection.getDBConnection();
        Connection connection = dbConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your Genre title: ");
        String title = scanner.nextLine();
        PreparedStatement getID = connection.prepareStatement("SELECT MAX(ID) as MAX FROM GENRES");
        ResultSet resultSet = getID.executeQuery();
        resultSet.next();
        int ID = resultSet.getInt("MAX") + 1;
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Genres VALUES(?,?)");
        stmt.setInt(1, ID);
        stmt.setString(2, title);
        if (!stmt.execute()) {
            System.out.println("Your genre was added successfully!");
        }
    }
}
