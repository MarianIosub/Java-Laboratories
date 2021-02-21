package com.company;

public class NanoSec {
    private long t1, t2;

    NanoSec() {
        t1 = 0;
        t2 = 0;
    }

    public void setT1(long x) {
        t1 = x;
    }

    public void setT2(long x) {
        t2 = x;
    }

    public void printareTimpi() {
        System.out.println("Rularea programului a durat: " + (t2 - t1) + " nanosecunde");
    }
}
