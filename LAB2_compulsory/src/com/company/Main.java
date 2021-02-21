package com.company;


public class Main {

    public static void main(String[] args) {
        Source S1 = new Source();
        Source S2 = new Source();
        Source S3 = new Source();
        S1.setType("FACTORY");
        S2.setType("WAREHOUSE");
        S3.setType("WAREHOUSE");
        S1.setName("S1");
        S2.setName("S2");
        S3.setName("S3");
        S1.setSupply(10);
        S2.setSupply(35);
        S3.setSupply(25);
        System.out.println(S1.toString());
        System.out.println(S2.toString());
        System.out.println(S3.toString());
        Destination D1 = new Destination();
        Destination D2 = new Destination();
        Destination D3 = new Destination();
        D1.setName("D1");
        D2.setName("D2");
        D3.setName("D3");
        D1.setComodities(20);
        D2.setComodities(25);
        D3.setComodities(25);
        System.out.println(D1.toString());
        System.out.println(D2.toString());
        System.out.println(D3.toString());
        Problem P = new Problem(3, 3);
        int[][] matrice = {{2, 3, 1, S1.getCapacity()},
                {5, 4, 8, S2.getCapacity()},
                {5, 6, 8, S3.getCapacity()},
                {D1.getComodities(), D2.getComodities(), D3.getComodities(), 0}};
        P.setMatrice(matrice);
        P.getMatrice();
    }
}
