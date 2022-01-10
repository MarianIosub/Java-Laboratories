package com.company;

import java.util.Objects;

/**
 * This is the definition of the abstract class Source
 */
public abstract class Source {
    private String name;
    private int capacity;
    private String type;

    /**
     * Creates an object of type Source and initializes its attributes
     */
    Source() {
        name = null;
        capacity = 0;
        type = null;
    }

    /**
     * This method sets the name of the source
     *
     * @param name is the name given to the source
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets capacity of the source
     *
     * @param capacity a number of capacity
     */
    public void setSupply(int capacity) {
        this.capacity = capacity;
    }

    /**
     * This method returns the name of the source
     *
     * @return the name of the source
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the number of capacity of the source
     *
     * @return the number of capacity of the source
     */
    public int getCapacity() {
        return capacity;
    }


    public String getType() {
        return type;
    }

    /**
     * @return the description of the source
     */
    @Override
    public String toString() {
        return "Your source of type: " + type + " having name: " + name + " and capacity: " + capacity;
    }

    /**
     * @param o is an given object
     * @return true if the object given is equal with this one and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return capacity == source.capacity && name.equals(source.name) && Objects.equals(type, source.type);
    }


}
