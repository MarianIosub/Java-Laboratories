import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void shell() throws SQLException, InterruptedException, IOException {
        DBConnection dbConnection = DBConnection.getDBConnection();
        Connection connection = dbConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            shellCommands();
            String commandIndex = scanner.nextLine();
            switch (commandIndex) {
                case "1": {
                    GetMovie.findMovieByID(connection);
                    continue;
                }
                case "2": {
                    GetMovie.findMovieByName(connection);
                    continue;
                }
                case "3": {
                    GetGenre.findGenreByID(connection);
                    continue;
                }
                case "4": {
                    GetGenre.findGenreByName(connection);
                    continue;
                }
                case "5": {
                    AddMovie.insertMovie(connection);
                    continue;
                }
                case "6": {
                    AddGenre.insertGenre(connection);
                    continue;
                }
                case "7":{
                    GetActors.findActorsofFilm(connection);
                    continue;
                }
                case "8":{
                    GetDirectory.findDirectorofFilm(connection);
                    continue;
                }
                case "9":{
                    GetFromIMDB.findOnIMDB();
                    continue;
                }
                case "10": {
                    System.out.println("Thank you! Have a nice day!");
                    System.exit(1);
                }
                default: {
                    System.out.println("Wrong command index! Try again!");
                }

            }
        }
    }

    public static void shellCommands() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\n\nYou have the next commands:");
        System.out.println("1 - Find a movie by ID");
        System.out.println("2 - Find a movie by title");
        System.out.println("3 - Find a genre by ID");
        System.out.println("4 - Find a genre by title");
        System.out.println("5 - Add a Movie");
        System.out.println("6 - Add a Genre");
        System.out.println("7 - Find actors by film name");
        System.out.println("8 - Find director by film name");
        System.out.println("9 - Find a movie on IMDB");
        System.out.println("10 - Quit\n\n");
        System.out.print("Type your command index: ");
    }

    public static void main(String[] args) throws SQLException, InterruptedException, IOException {
        shell();
    }
}
