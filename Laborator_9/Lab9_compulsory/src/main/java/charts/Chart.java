package charts;

import entities.Movies;
import entityManagerFactory.Manager;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Chart {
    private List<Movies>moviesChart;
    private EntityManager entityManager;
    private Date creationDate;
    private String name;

    public Chart(String name,Date creationDate) {
        this.name = name;
        entityManager= Manager.getInstance().getManager();
        this.creationDate= creationDate;
    }
    public void getChart(){
        System.out.println(moviesChart);
    }
    public void populateChart(){
        moviesChart=(List<Movies>) entityManager.createNamedQuery("Movies.chart")
                .getResultList();
        Collections.sort(moviesChart,Collections.reverseOrder());
    }

    @Override
    public String toString() {
        return "Chart{" +
                "moviesChart=" + moviesChart +
                ", entityManager=" + entityManager +
                ", creationDate=" + creationDate +
                ", name='" + name + '\'' +
                '}';
    }
}
