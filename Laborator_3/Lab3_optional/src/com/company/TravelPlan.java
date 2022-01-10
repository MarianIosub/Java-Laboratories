package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TravelPlan {
    City city;
    List<Location> preferences;


    TravelPlan(City city) {
        this.city = city;
        preferences = new ArrayList<>();

    }

    public void setPreferences(List<Location> preferences) {
        this.preferences = preferences;
    }

    public City getCity() {
        return city;
    }

    public List<Location> getPreferences() {
        return preferences;
    }

    public void planSolution(Location startLocation, Location finishLocation) {
        int n = city.getNodes().size();
        System.out.println(n);
        int dist[][] = new int[n][n];
        int i, j, k;

        //Este algortimul Floys-Warshall, astfel incat am creat o matrice a problemei cu distanta din mapa de la o locatie la alta
        //ca apoi cu cele 3 for-uri sa parcurg si sa aflu distanta minima de la o locatie la alta, caruia ii dau update in dist daca este mai mica decat cea curenta
        for (Location location : city.getNodes()) {
            Map<Location, Integer> costCopy = location.getCost();
            System.out.println(costCopy);
            for (Location secondLocation : city.getNodes()) {
                dist[city.getNodes().indexOf(location)][city.getNodes().indexOf(secondLocation)] = costCopy.getOrDefault(secondLocation, 10000);
            }

        }

        for (k = 0; k < n; k++) {

            for (i = 0; i < n; i++) {

                for (j = 0; j < n; j++) {

                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        System.out.println("Minimum distance between " + startLocation.getName() + " and " + finishLocation.getName() + " is " + dist[city.getNodes().indexOf(startLocation)][city.getNodes().indexOf(finishLocation)]);


    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "city=" + city.getName() +
                ", preferences=" + preferences +
                '}' + "\n";
    }
}
