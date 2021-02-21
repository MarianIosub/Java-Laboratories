package com.company;

public class Main {

    public static void main(String[] args) {
        Tree A = new Tree(Integer.parseInt("6"));
        A.matrixGenerate();
        A.printareMatrice();
        A.isConnected();
        A.partialTree(0);
    }
}
