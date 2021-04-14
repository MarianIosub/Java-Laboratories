import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMovie {
    public static void insertMovie(Connection connection) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your movie title: ");
        String title = scanner.nextLine();
        int ID;
        PreparedStatement getID = connection.prepareStatement("SELECT MAX(ID) as MAX FROM MOVIES");
        ResultSet resultSet = getID.executeQuery();
        resultSet.next();
        ID = resultSet.getInt("MAX") + 1;
        System.out.print("Type your movie's duration time: ");
        int duration = scanner.nextInt();
        System.out.print("Type your movie's rating: ");
        float rating = scanner.nextFloat();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO movies VALUES(?,?,SYSDATE,?,?)");
        stmt.setInt(1, ID);
        stmt.setString(2, title);
        stmt.setInt(3, duration);
        stmt.setFloat(4, rating);
        if (!stmt.execute()) {
            System.out.println("You film was added successfully!");
        }
    }
}
