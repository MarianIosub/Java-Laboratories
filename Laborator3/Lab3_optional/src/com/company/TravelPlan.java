package com.company;

import java.util.ArrayList;
import java.util.List;

public class TravelPlan {
    City city;
    List<Location> preferences;

    TravelPlan(City city) {
        this.city = city;
        preferences=new ArrayList<>();

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

    @Override
    public String toString() {
        return "TravelPlan{" +
                "city=" + city.getName() +
                ", preferences=" + preferences +
                '}'+"\n";
    }
}
