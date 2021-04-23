package entities.repos;

import entities.Movies;
import entityManagerFactory.Manager;

import javax.persistence.EntityManager;
import java.util.List;

public class MovieRepository {
    static EntityManager manager;

    public MovieRepository() {
        Manager managerInstance = Manager.getInstance();
        manager = managerInstance.getManager();
        manager.getTransaction().begin();
    }

    public static Movies findByID(String id) {

        Movies movie = manager.find(Movies.class, id);
        manager.getTransaction();
        return movie;

    }

    public static void create(Movies movie) {
        manager.persist(movie);
        manager.getTransaction().commit();

    }

    public static List<Movies> findByName(String name) {
        List<Movies> moviesFound = (List<Movies>) manager.createNamedQuery("Movies.findByName")
                .setParameter("title", name)
                .getResultList();
        return moviesFound;
    }


    public static void setManager(EntityManager manager) {
        MovieRepository.manager = manager;
    }

    public static void closeManager() {
        manager.close();
    }
}
