package com.company;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    default LocalTime getOpeningTime() {
        return LocalTime.of(9, 30);
    }

    default LocalTime getClosingTime() {
        return LocalTime.of(20, 00);
    }

    static Duration openingPeriod(LocalTime openingTime, LocalTime closingTime) {
        Duration period = Duration.between(openingTime, closingTime);
        return period;
    }


}
