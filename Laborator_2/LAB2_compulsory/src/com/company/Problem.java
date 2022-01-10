package com.company;

public class Problem {
    private int nrSources;
    private int nrDestinations;
    private int[][] matrice;

    Problem(int n, int m) {
        nrSources = n;
        nrDestinations = m;
        matrice = new int[n + 1][m + 1];
    }

    public void getMatrice() {
        System.out.println("Matricea corespunzatoare problemei este: ");
        for (int i = 0; i < nrSources + 1; i++) {
            for (int j = 0; j < nrDestinations + 1; j++)
                System.out.print(matrice[i][j]+" ");
            System.out.println();
        }
    }

    public int getNrDestinations() {
        return nrDestinations;
    }

    public int getNrSources() {
        return nrSources;
    }

    public void setMatrice(int[][] matrice) {
        for (int i = 0; i < nrSources + 1; i++)
            for (int j = 0; j < nrDestinations + 1; j++)
                this.matrice[i][j] = matrice[i][j];
    }
}
