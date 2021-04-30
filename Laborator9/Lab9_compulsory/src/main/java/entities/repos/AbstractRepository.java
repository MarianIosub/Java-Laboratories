package entities.repos;

import entities.Movies;
import entityManagerFactory.Manager;

import javax.persistence.EntityManager;

public abstract class AbstractRepository <T>{
    static EntityManager manager;

    public AbstractRepository() {
        Manager managerInstance = Manager.getInstance();
        manager = managerInstance.getManager();
    }
    public void create(T entity) {
        manager.persist(entity);
        manager.getTransaction().commit();
    }
}
