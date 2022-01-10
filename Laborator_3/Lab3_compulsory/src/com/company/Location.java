package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location> {
    private String name;
    private Map<Location, Integer> cost = new HashMap<>();

    public Location() {
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    public String getName() {
        return name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }


    @Override
    public int compareTo(Location other) {
        if (this.name != null)
            return this.name.compareTo(other.name);
        return 0;
    }


    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                '}';
    }
}
