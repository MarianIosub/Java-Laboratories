package com.company;

/**
 * The definition of the derived class Warehouse
 */
public class Warehouse extends Source {
    private String name;
    private int capacity;
    private String type;

    /**
     * Creates a new object of type Warehouse and initializes its attributes
     *
     * @param name     is the name of the Warehouse
     * @param capacity is the capacity of the Warehouse
     */
    Warehouse(String name, int capacity) {
        super.setSupply(capacity);
        super.setName(name);
        type = "Warehouse";
    }
}
