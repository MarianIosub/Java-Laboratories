package jdbc;

import entities.repos.AbstractRepository;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class AddMovie extends AbstractRepository {
    public static void insertMovie(Connection connection) throws SQLException, ParseException {
        Movie movie=new Movie(null,null,null,null,null);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type your movie title: ");
        String title = scanner.nextLine();
        movie.setTitle(title);
        int ID;
        PreparedStatement getID = connection.prepareStatement("SELECT MAX(ID) as MAX FROM MOVIES");
        ResultSet resultSet = getID.executeQuery();
        resultSet.next();
        ID = resultSet.getInt("MAX") + 1;
        movie.setId(ID);
        System.out.print("Type your movie's duration time: ");
        int duration = scanner.nextInt();
        movie.setDuration(duration);
        System.out.print("Type your movie's rating: ");
        float rating = scanner.nextFloat();
        movie.setRating((double) rating);
        movie.setReleaseDate(Date.valueOf(LocalDate.now()));
        //Am incercat sa citest data de la tastatura dar nu merge :(
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO movies VALUES(?,?,?,?,?)");
        stmt.setInt(1, movie.getId());
        stmt.setString(2, movie.getTitle());
        stmt.setInt(4, movie.getDuration());
        stmt.setFloat(5, movie.getRating().floatValue());
        stmt.setDate(3, Date.valueOf(String.valueOf(movie.getReleaseDate())));
        if (!stmt.execute()) {
            System.out.println("You film was added successfully!");
        }
    }
}
