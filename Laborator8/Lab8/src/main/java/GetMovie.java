import java.sql.*;
import java.util.Scanner;

public class GetMovie {

    public static void findMovieByName() throws SQLException {
        DBConnection dbConnection = DBConnection.getDBConnection();
        Connection connection = dbConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your film title: ");
        String title = scanner.nextLine();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM movies where title=?");
        stmt.setString(1, title);
        ResultSet rs = stmt.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.print("Your film has the ID: " + rs.getString("ID"));
            System.out.print(" and the title: " + rs.getString("Title"));
            System.out.print(" was released on: " + rs.getString("release_date"));
            System.out.print(", has duration : " + rs.getString("duration"));
            System.out.print(" minutes and rating: " + rs.getString("score"));
        }
        if (!found) {
            System.out.println("Your film wasn't found");
        }
    }

    public static void findMovieByID() throws SQLException {
        DBConnection dbConnection = DBConnection.getDBConnection();
        Connection connection = dbConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your film ID: ");
        Integer id = scanner.nextInt();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM movies where ID=?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.print("Your film has the ID: " + rs.getString("ID"));
            System.out.print(" and the title: " + rs.getString("Title"));
            System.out.print(" was released on: " + rs.getString("release_date"));
            System.out.print(", has duration : " + rs.getString("duration"));
            System.out.print(" minutes and rating: " + rs.getString("score"));
        }
        if (!found) {
            System.out.println("Your film wasn't found");
        }
    }
}

