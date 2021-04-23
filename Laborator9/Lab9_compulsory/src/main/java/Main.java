import entities.repos.MovieRepository;
import entities.Movies;
import entityManagerFactory.Manager;

public class Main {
    public static void main(String[] args) {
        System.out.println("dada");
        Manager manager=Manager.useManager();
        MovieRepository.setManager(manager.getManager());
//      FIND A MOVIE BY ID
        Movies movies1=MovieRepository.findByID("1");
        System.out.println(movies1);
//      INSERT A MOVIE
/*      Movies movieToAdd=new Movies("40","TEST",java.sql.Date.valueOf(LocalDate.now()),"120",4.3);
        MovieRepository.create(movieToAdd);
        Movies movies2=MovieRepository.findByID("20");
        System.out.println(movies2);*/
//      FIND A MOVIE BY NAME
        System.out.println(MovieRepository.findByName("TEST"));
        MovieRepository.closeManager();
    }
}
