package com.company;


public class Main {

    public static void main(String[] args) {
        Problem problem = new Problem();
        Warehouse A = new Warehouse("S1", 10);
        Warehouse B = new Warehouse("S2", 35);
        Factory C = new Factory("S3", 25);
        Destination X = new Destination("D1", 20);
        Destination Y = new Destination("D2", 25);
        Destination Z = new Destination("D3", 25);
        problem.addSource(A);
        problem.addSource(B);
        problem.addSource(C);
        problem.addDestination(X);
        problem.addDestination(Y);
        problem.addDestination(Z);
        int[][] matrice = { {2, 3, 1},
                            {5, 4, 8},
                            {5, 6, 8}};
        problem.setMatrice(matrice);
        problem.getMatrice();
        Solution solution = new Solution();
//        solution.getSolution(problem);
        solution.getBonusSolution(problem);

    }
}
