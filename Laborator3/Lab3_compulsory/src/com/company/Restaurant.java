package com.company;

import java.time.LocalTime;
import java.util.Map;

public class Restaurant extends Location implements Visitable, Classifiable {
    private LocalTime openingTime, closingTime;
    private double ranking;

    public Restaurant() {
    }

    @Override
    public double getRanking() {
        return ranking;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }
}
