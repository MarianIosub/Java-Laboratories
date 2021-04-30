package factory;

import entities.repos.AbstractRepository;

public interface AbstractFactory {
    public AbstractRepository createRepository(String type);
}
