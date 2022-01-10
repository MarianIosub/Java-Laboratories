package entities.repos;

import entities.Movies;
import entityManagerFactory.Manager;

import javax.persistence.EntityManager;
import java.util.List;

public class MovieRepository extends AbstractRepository<Movies> {

    public MovieRepository() {
        super();
    }

    public Movies findByID(String id) {

        Movies movie = manager.find(Movies.class, id);
        manager.getTransaction();
        return movie;

    }


    public List<Movies> findByName(String name) {
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
