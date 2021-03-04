package com.company;


/**
 * This is the definition of the class Destination
 */
public class Destination {
    private int comodities;

    private String name;

    /**
     * Creates an object of type Destination and initializes its attributes
     *
     * @param name     is the name of the destination
     * @param capacity is the number of comodities of the destination
     */
    Destination(String name, int capacity) {
        this.setComodities(capacity);
        this.setName(name);
    }

    /**
     * This method sets comodities of the destination
     *
     * @param comodities a number of comodities
     */
    public void setComodities(int comodities) {
        this.comodities = comodities;
    }

    /**
     * This method sets the name of the destination
     *
     * @param name is the name given to the destination
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the number of comodities of the destination
     *
     * @return the number of comodities of the destination
     */
    public int getComodities() {
        return comodities;
    }

    /**
     * This method returns the name of the destination
     *
     * @return the name of the destination
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description of the destination
     */
    @Override
    public String toString() {
        return "Your destination having name: " + name + " and capacity: " + comodities;
    }

    /**
     * @param o is an given object
     * @return true if the object given is equal with this one and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return comodities == that.comodities && name.equals(that.name);
    }

}
