package com.company;


public class Main {

    public static void main(String[] args) {
        NanoSec X = new NanoSec();
        X.setT1(System.nanoTime());
        MatrixCalc A = new MatrixCalc(Integer.parseInt("5"));
        A.matrixGenerate();
        A.printareMatrice();
        A.isConnected();
        A.partialTree(0);
        X.setT2(System.nanoTime());
        X.printareTimpi();
    }

}
