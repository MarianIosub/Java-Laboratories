import java.sql.*;
import java.util.Scanner;

public class GetMovie {

    public static void findMovieByName(Connection connection) throws SQLException {
        Movie movie=null;
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
            filmID=rs.getString("ID");
            movie= new Movie(rs.getString("Title"),Integer.parseInt(rs.getString("ID")),null,Integer.parseInt(rs.getString("duration")),rs.getDouble("score"),rs.getDate("release_date"));
        }
        if (!found) {
            System.out.println("Your film wasn't found");
            return;
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
                    movie.setGenre(getGenreName.getString("Genre"));

                }
                System.out.println(movie);
            }
        }
    }

    public static void findMovieByID(Connection connection) throws SQLException {
        Movie movie=null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your film ID: ");
        Integer id = scanner.nextInt();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM movies where ID=?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            movie= new Movie(rs.getString("Title"),Integer.parseInt(rs.getString("ID")),null,Integer.parseInt(rs.getString("duration")),rs.getDouble("score"),rs.getDate("release_date"));
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
                    movie.setGenre(getGenreName.getString("Genre"));

                }
                System.out.println(movie);
            }
        }
    }
}


