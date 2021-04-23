package entityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private Manager(){
    this.factory= Persistence.createEntityManagerFactory("Lab9_compulsory");
    this.manager=factory.createEntityManager();
    }
    public static Manager useManager(){
        Manager manager=new Manager();
        return manager;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getManager() {
        return manager;
    }
}
