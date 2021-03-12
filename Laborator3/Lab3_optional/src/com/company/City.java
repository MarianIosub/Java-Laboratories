package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class City implements Visitable {
    private List<Location> nodes = new ArrayList<>();
    String name;
    public City() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
        for (int index = 0; index < nodes.size(); index++) {
            System.out.println(nodes.get(index).getCost());
        }
    }

    public void sortVisitables() {
        List<Location> locationVisitables = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof Visitable && !(nodes.get(i) instanceof Payable)) {
                locationVisitables.add(nodes.get(i));
            }
        }

        Collections.sort(locationVisitables);
        System.out.println("The sort for your visitable but not payable locations is:");
        System.out.println(locationVisitables);
        System.out.println();
    }

    @Override
    public String toString() {

        return "City{" +
                "nodes=" + nodes +
                '}';
    }
}
