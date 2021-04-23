import entities.Movies;
import entities.repos.MovieRepository;
import entityManagerFactory.Manager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieRepositoryTest {
 private static Manager manager;
 @BeforeAll
    public static void instanceManager(){
     manager=Manager.getInstance();
 }
 @Test
    public void findByID(){
     MovieRepository.setManager(manager.getManager());
     Movies movies1= MovieRepository.findByID("1");
     assertEquals("120",movies1.getDuration());
 }
}
