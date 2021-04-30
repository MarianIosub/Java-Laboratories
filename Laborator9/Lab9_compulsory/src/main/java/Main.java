import charts.Chart;
import entities.repos.AbstractRepository;
import entities.repos.MovieRepository;
import entities.Movies;
import entityManagerFactory.Manager;
import factory.MovieFactory;
import jdbc.DBConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static Connection connection;
    public static void init(String type){
        if(type.equals("jdbc")){
            connection=DBConnection.getDBConnection().getConnection();
        }
    }
    public static String getType() throws IOException {
        String type=null;
        BufferedReader bufferedReader=new BufferedReader(new FileReader("type.txt"));
        type=bufferedReader.readLine();
        return type;
    }
    public static void main(String[] args) throws IOException {
        EntityManager manager=Manager.getInstance().getManager();
        MovieRepository movieRepository=new MovieRepository();
/*        Movies movieToAdd=new Movies("70","TEST", java.sql.Date.valueOf(LocalDate.now()),"120",4.3);
        movieRepository.create(movieToAdd);*/
        String type=getType();
        init(type);
        MovieFactory movieFactory=new MovieFactory();
        AbstractRepository<Movies> moviesAbstractRepository=movieFactory.createRepository(type);
        Movies movieToAdd=new Movies("90","TEST", java.sql.Date.valueOf(LocalDate.now()),"120",4.3);
        moviesAbstractRepository.create(movieToAdd);
        Chart chart=new Chart("CurrentChart",null);
        chart.populateChart();
        chart.getChart();
        Manager.closeManager();
    }
}
