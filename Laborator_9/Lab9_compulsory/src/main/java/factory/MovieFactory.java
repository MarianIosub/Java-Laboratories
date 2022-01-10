package factory;

import entities.repos.AbstractRepository;
import entities.repos.MovieRepository;
import jdbc.AddMovie;

public class MovieFactory implements AbstractFactory{


    @Override
    public AbstractRepository createRepository(String type) {
        switch (type){
            case "jdbc":{
                return new AddMovie();
            }
            case "jpa":{
                return new MovieRepository();
            }
            default:{
                return null;
            }
        }
    }
}
