import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GetFromIMDB {

    public static void findOnIMDB() throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please type your movie title:");
        String movieTitle=scanner.nextLine();
        String lineRead=null;
        String splitter=",";
        BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\Marian\\Desktop\\IMDb-movies.csv"));
        while((lineRead=reader.readLine())!=null){
            String[] movieDetails=lineRead.split(splitter);
            if(movieDetails[1].equals(movieTitle)){
                System.out.println("Your movie was found on IMDB and have the details:");
                System.out.println("- original title: "+movieDetails[2]);
                System.out.println("- date-published: "+movieDetails[4]);
                System.out.println("- duration: "+movieDetails[6]);
                System.out.println("- genre: "+movieDetails[5]);
                System.out.println("- score: "+movieDetails[14]);
                System.out.println("- director: "+movieDetails[9]);
                System.out.println("- actors: "+movieDetails[12]);
                return;
            }
        }
        System.out.println("Movie '"+movieTitle+"' was not found on IMDB!");

    }

}
