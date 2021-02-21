package com.company;

public class Tree {
    private int n;
    private int[][] matrice;
    private int[][] tree;
    private boolean isConnected = false;

    Tree(int x) {
        n = x;
        matrice = new int[n][n];
        tree = new int[n][n];
    }

    public void matrixGenerate() {
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                matrice[i][j] = matrice[j][i] = (int) (Math.random() * 1000000) % 2;
        for (int i = 0; i < n; i++)
            matrice[i][i] = 0;
    }

    public void printareMatrice() {
        System.out.println("Matricea ta de " + n + " linii si " + n + " coloane corespunzatoare grafului este:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrice[i][j] + " ");
            System.out.println();

        }
    }

    public void parcurgere(int u, boolean[] visited) {
        visited[u] = true;
        for (int i = 0; i < n; i++) {
            if (matrice[u][i] == 1)
                if (!visited[i])
                    parcurgere(i, visited);
        }
    }

    public void printSpatii(int i) {
        for (int j = 0; j < i; j++)
            System.out.print("   ");

    }

    public void generateTree(int x) {
        boolean[] visited = new boolean[n];
        int numar = 0;
        System.out.println("Arborele corespunzator grafului tau arata asa: ");
        parcurgereTree(x, visited, numar);
    }

    public void parcurgereTree(int u, boolean[] visited, int numar) {

        printSpatii(numar);
        System.out.println("|->" + u);
        visited[u] = true;
        numar++;
        for (int i = 0; i < n; i++)
            if (tree[u][i] == 1)
                if (!visited[i]) {

                    parcurgereTree(i, visited, numar);

                }


    }

    public void isConnected() {
        int nrComp = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            visited[i] = false;
        for (int i = 0; i < n; i++)
            if (!visited[i]) {
                parcurgere(i, visited);
                nrComp++;
            }


        if (nrComp == 1)
            isConnected = true;

    }


    public void bfs(int x) {

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            visited[i] = false;
        visited[x] = true;
        int queue = 0, poz = 0, curent;
        int[] v = new int[n + 1];

        for (int i = 0; i <= n; i++)
            v[i] = -1;
        v[0] = x;

        while (v[queue] != -1) {
            curent = v[queue];
            for (int i = 0; i < n; i++)
                if (matrice[curent][i] == 1 && !visited[i]) {
                    v[++poz] = i;
                    visited[i] = true;
                    tree[curent][i] = tree[i][curent] = 1;
                }
            queue++;
        }
        System.out.println("Matricea de adiacenta a arborelui tau este:");
        for (int i = 0; i < n; i++) {
            {
                for (int j = 0; j < n; j++)
                    System.out.print(tree[i][j] + " ");
                System.out.println();
            }
        }
    }

    public void partialTree(int x) {
        if (n <= x) System.out.println("Nodul introdus nu exista!");
        else if (!isConnected)
            System.out.println("Graful tau nu este conex deci nu se poate genera un arbore partial");
        else {
            bfs(x);
            generateTree(x);

        }
    }

}
