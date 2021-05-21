package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the definition of the class Solution
 */
public class Solution {


    /**
     * Receives a problem with its parameters.
     * First, it iterates all the sources of the given problem.
     * For every source, it iterates all the destinations and keeps it in variable 'minim' and the destination index in 'destination'.
     * Then, in case of the tests, it will makes the following:
     * nothing if it's not destination kept;
     * if the destination comodities is bigger than the capacity of the source, the capacity of the source will become 0, the comodities of the destination will be updated and the total cost will be increased;
     * if the source capacities is bigger than the comodities of the destination, the comosities of the destination will become 0, the capacity of the cource will be updated and the total cost will be increased.
     * In the final, if the source also has capacities, it will remain at that one and will verify again all the destinations available.
     * The total cost after the solution of the problem is over will be printed on the screen.
     *
     * @param problem is a given problem of type Problem
     */
    void getSolution(Problem problem) {
        System.out.println("Solution: ");
        int totalCost = 0;
        for (int i = 0; i < problem.getNrSources(); i++) {
            int minim = Integer.MAX_VALUE;
            int destination = -1;
            for (int j = 0; j < problem.getNrDestinations(); j++) {
                if (problem.matrice[i][j] < minim && problem.destinations[j].getComodities() > 0) {
                    minim = problem.matrice[i][j];
                    destination = j;
                }

            }
            if (destination == -1) {
                return;
            } else if (problem.destinations[destination].getComodities() > problem.sources[i].getCapacity()) {//daca demand-ul> supply susei, oferim tot supply-ul
                System.out.println(problem.sources[i].getName() + " -> " + problem.destinations[destination].getName() + ": " + problem.sources[i].getCapacity() + " units * cost " + minim + " = " + (problem.sources[i].getCapacity() * minim));
                totalCost += problem.sources[i].getCapacity() * minim;
                problem.destinations[destination].setComodities(problem.destinations[destination].getComodities() - problem.sources[i].getCapacity());
                problem.sources[i].setSupply(0);
            } else { //daca demand-ul este mai mic egal decat supply-ul sursei, oferim exact cat se cere
                System.out.println(problem.sources[i].getName() + " -> " + problem.destinations[destination].getName() + ": " + problem.destinations[destination].getComodities() + " units * cost " + minim + " = " + (problem.destinations[destination].getComodities() * minim));
                totalCost += problem.destinations[destination].getComodities() * minim;
                problem.sources[i].setSupply(problem.sources[i].getCapacity() - problem.destinations[destination].getComodities());
                problem.destinations[destination].setComodities(0);
            }
            if (problem.sources[i].getCapacity() > 0)
                i--;
        }
        System.out.println("Total cost: " + totalCost);
    }

    public void getBonusSolution(Problem problem) {
        List<SourceToDestinationPrice> prices = new ArrayList<>();
        for (int i = 0; i < problem.getNrSources(); i++) {
            for (int j = 0; j < problem.getNrDestinations(); j++) {
                prices.add(new SourceToDestinationPrice(problem.sources[i], problem.destinations[j], problem.matrice[i][j]));
            }
        }
        prices.sort(SourceToDestinationPrice::compareTo);
        System.out.println(prices);
        Integer totalCost = 0;
        for (SourceToDestinationPrice price : prices) {
            if (price.getSource().getCapacity() > 0 && price.getDestination().getComodities() > 0) {
                if (price.getDestination().getComodities() > price.getSource().getCapacity()) {
                    System.out.println(price.getSource().getName() + " -> " + price.getDestination().getName() + ": " + price.getSource().getCapacity() + " units * cost " + price.getPrice() + " = " + (price.getSource().getCapacity() * price.getPrice()));
                    totalCost += price.getSource().getCapacity() * price.getPrice();
                    price.getDestination().setComodities(price.getDestination().getComodities() - price.getSource().getCapacity());
                    price.getSource().setSupply(0);
                } else {
                    System.out.println(price.getSource().getName() + " -> " + price.getDestination().getName() + ": " + price.getDestination().getComodities() + " units * cost " + price.getPrice() + " = " + (price.getDestination().getComodities() * price.getPrice()));
                    totalCost+=price.getDestination().getComodities() * price.getPrice();
                    price.getSource().setSupply(price.getSource().getCapacity()-price.getDestination().getComodities());
                    price.getDestination().setComodities(0);
                }
            }
        }
        System.out.println("Total cost is:   "+totalCost);
    }
}
