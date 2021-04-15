import java.sql.*;
import java.util.Scanner;

public class GetMovie {

    public static void findMovieByName(Connection connection) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your film title: ");
        String title = scanner.nextLine();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM movies where title=?");
        stmt.setString(1, title);
        ResultSet rs = stmt.executeQuery();
        boolean found = false;
        String filmID = null;
        while (rs.next()) {
            found = true;
            System.out.print("Your film has the ID: " + rs.getString("ID"));
            System.out.print(" and the title: " + rs.getString("Title"));
            System.out.print(" was released on: " + rs.getString("release_date"));
            System.out.print(", has duration : " + rs.getString("duration"));
            System.out.print(" minutes and rating: " + rs.getString("score"));
            filmID = rs.getString("ID");
        }
        if (!found) {
            System.out.println("Your film wasn't found");
        }
        if (found) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MOVIE_GENRE WHERE ID_MOVIE=?");
            statement.setInt(1, Integer.parseInt(filmID));
            ResultSet genreResult = statement.executeQuery();
            boolean genreFound = false;
            String genreID = null;
            while (genreResult.next()) {
                genreID = genreResult.getString("id_genre");
                genreFound = true;
            }
            if (genreFound) {
                PreparedStatement getGenre = connection.prepareStatement("SELECT Genre FROM GENREs WHERE ID=?");
                getGenre.setInt(1, Integer.parseInt(genreID));
                ResultSet getGenreName = getGenre.executeQuery();
                while (getGenreName.next()) {
                    System.out.println(". Your film has genre " + getGenreName.getString("Genre")+".");

                }
            }
        }
    }

    public static void findMovieByID(Connection connection) throws SQLException {

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
        if (found) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MOVIE_GENRE WHERE ID_MOVIE=?");
            statement.setInt(1, id);
            ResultSet genreResult = statement.executeQuery();
            boolean genreFound = false;
            String genreID = null;
            while (genreResult.next()) {
                genreID = genreResult.getString("id_genre");
                genreFound = true;
            }
            if (genreFound) {
                PreparedStatement getGenre = connection.prepareStatement("SELECT Genre FROM GENREs WHERE ID=?");
                getGenre.setInt(1, Integer.parseInt(genreID));
                ResultSet getGenreName = getGenre.executeQuery();
                while (getGenreName.next()) {
                    System.out.println(". Your film has genre " + getGenreName.getString("Genre")+".");

                }
            }
        }
    }
}


