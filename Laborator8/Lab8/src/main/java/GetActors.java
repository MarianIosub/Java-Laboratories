import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetActors {
    public static void findActorsofFilm(Connection connection) throws SQLException {
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
        statement=connection.prepareStatement("SELECT ACTOR_NAME AS ACTOR FROM ACTORS WHERE ID_MOVIE=?");
        statement.setInt(1,movieID);
        ResultSet actorsResult=statement.executeQuery();
        System.out.println("Your film has the actors: ");
        boolean found=false;
        while(actorsResult.next()){
            found=true;
            System.out.println("-"+actorsResult.getString("ACTOR"));
        }
        if(!found){
            System.out.println("You film was not found or it hasn't actors saved!");
        }
    }
}
