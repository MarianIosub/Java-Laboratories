package com.company;

import java.time.LocalTime;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        City c = new City();
        c.setName("Iasi");
        Hotel h1 = new Hotel();
        h1.setRanking(4.5);
        h1.setName("Unirea");
        Museum h2 = new Museum();
        h2.setName("Palatul Culturii");
        h2.setClosingTime(LocalTime.MIDNIGHT);
        h2.setOpeningTime(LocalTime.NOON);
        h2.setTicketPrice(10.5);
        Museum h3 = new Museum();
        h3.setName("Muzeul istoriei");
        h3.setClosingTime(LocalTime.MIDNIGHT);
        h3.setOpeningTime(LocalTime.NOON);
        h3.setTicketPrice(8.2);
        Church h4 = new Church();
        h4.setName("Mitropolia");
        h4.setClosingTime(LocalTime.MIDNIGHT);
        h4.setOpeningTime(LocalTime.NOON);
        Church h5 = new Church();
        h5.setName("Patriarhia");
        h5.setClosingTime(LocalTime.MIDNIGHT);
        h5.setOpeningTime(LocalTime.NOON);
        Restaurant h6 = new Restaurant();
        h6.setRanking(9.2);
        h6.setName("Oscar");
        h6.setClosingTime(LocalTime.MIDNIGHT);
        h6.setOpeningTime(LocalTime.NOON);
        h1.setCost(h2, 10);
        h1.setCost(h3, 50);
        h2.setCost(h3, 20);
        h3.setCost(h2, 20);
        h2.setCost(h4, 20);
        h2.setCost(h5, 10);
        h3.setCost(h4, 20);
        h4.setCost(h5, 30);
        h5.setCost(h4, 30);
        h4.setCost(h6, 10);
        h5.setCost(h6, 20);
        c.addLocation(h1);
        c.addLocation(h2);
        c.addLocation(h3);
        c.addLocation(h4);
        c.addLocation(h5);
        c.addLocation(h6);
        System.out.println("Visitable period of location: " + h6.getName() + " is: " + Visitable.openingPeriod(h6.getClosingTime(), h6.getOpeningTime()) +"\n");
        c.sortVisitables();
        TravelPlan plan=new TravelPlan(c);
        plan.setPreferences(Arrays.asList(h4,h5,h3,h2,h1,h6));
        System.out.println(plan);
        plan.planSolution(h1,h4);
    }
}
