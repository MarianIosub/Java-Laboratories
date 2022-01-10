package com.company;

public class Source {
    private String name;
    private int capacity;
    private String type;

    public enum SourceType {
        WAREHOUSE, FACTORY;
    }

    Source() {
        name = null;
        capacity = 0;
        type = null;
    }

    public void setName(String x) {
        name = x;
    }

    public void setSupply(int x) {
        capacity = x;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setType(String x) {
        int ok = 0;
        for (SourceType i : SourceType.values())
            if (i.name().equals(x)) {
                type = x;
                ok = 1;
            }
        if (ok == 0)
            System.out.println("Tipul introdus nu exista!");

    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Your source of type: " + type + " having name: " + name + " and capacity: " + capacity;
    }

}
