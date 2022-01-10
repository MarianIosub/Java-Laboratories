package com.company;

import java.util.Map;

public class Hotel extends Location implements Classifiable {
    private double ranking;

    public Hotel() {
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    @Override
    public double getRanking() {
        return ranking;
    }
}
