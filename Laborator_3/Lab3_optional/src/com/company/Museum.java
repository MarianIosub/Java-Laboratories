package com.company;

import java.time.LocalTime;
import java.util.Map;

public class Museum extends Location implements Visitable, Payable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    public Museum() {
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public LocalTime getOpeningTime() {
        if (openingTime == null)
            return Visitable.super.getOpeningTime();
        else
            return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        if (closingTime == null)
            return Visitable.super.getClosingTime();
        else
            return closingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
