package com.company;

import java.util.ArrayList;
import java.util.List;

public class City {
    private List<Location> nodes = new ArrayList<>();

    public City() {
    }

    public City(List<Location> nodes) {
        this.nodes = nodes;
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    public List<Location> getNodes() {
        return nodes;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    public void printCosts() {
        for (int index = 0; index < nodes.size(); index++)
            System.out.println(nodes.get(index).getCost());
    }

    @Override
    public String toString() {

        return "City{" +
                "nodes=" + nodes +
                '}';
    }
}
