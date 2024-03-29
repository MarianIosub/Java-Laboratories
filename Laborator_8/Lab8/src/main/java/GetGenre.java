import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetGenre {
    public static void findGenreByName(Connection connection) throws SQLException {
        Genre genre=null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your Genre title: ");
        String title = scanner.nextLine();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM genres where genre=?");
        stmt.setString(1, title);
        ResultSet rs = stmt.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            genre=new Genre(Integer.parseInt(rs.getString("ID")),rs.getString("genre"));
            System.out.println(genre);
        }
        if (!found) {
            System.out.println("Your genre wasn't found");
        }
    }

    public static void findGenreByID(Connection connection) throws SQLException {
        Genre genre=null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your Genre ID: ");
        Integer id = scanner.nextInt();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM genres where ID=?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            genre=new Genre(Integer.parseInt(rs.getString("ID")),rs.getString("genre"));
            System.out.println(genre);
        }
        if (!found) {
            System.out.println("Your genre wasn't found");
        }
    }
}
