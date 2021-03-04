package com.company;

/**
 * The definition of the derived class Factory
 */
public class Factory extends Source {
    private String name;
    private int capacity;
    private String type;

    /**
     * Creates a new object of type Factory and initializes its attributes
     *
     * @param name     is the name of the Factory
     * @param capacity is the capacity of the Factory
     */
    Factory(String name, int capacity) {
        super.setSupply(capacity);
        super.setName(name);
        type = "Factory";
    }
}
