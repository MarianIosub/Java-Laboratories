import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetDirectory {
    public static void findDirectorofFilm(Connection connection) throws SQLException {
        boolean found=false;
        System.out.print("Please input your movie title: ");
        Scanner scanner=new Scanner(System.in);
        String movie=scanner.nextLine();
        PreparedStatement statement=connection.prepareStatement("Select ID from movies where title=?");
        statement.setString(1,movie);
        ResultSet resultSet=statement.executeQuery();
        if(!resultSet.next()){
            System.out.println("Your film wasn't found!");
            return;
        }
        int movieID=resultSet.getInt("ID");
        statement=connection.prepareStatement("SELECT DIRECTOR_NAME as DIRECTOR  FROM DIRECTORIES WHERE ID_MOVIE=?");
        statement.setInt(1,movieID);
        ResultSet directorResult=statement.executeQuery();
        System.out.println("Your film has the director: ");

        while(directorResult.next()){
            Director director=new Director(directorResult.getString("DIRECTOR"));
            found=true;
            System.out.println("-"+director);
        }
        if(!found){
            System.out.println("You film hasn't actors saved!");
        }
    }
}
