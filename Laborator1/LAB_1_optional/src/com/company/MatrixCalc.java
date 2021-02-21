package com.company;

public class MatrixCalc {
    private int n;
    private int[][] matrice;
    private boolean isConnected = false;

    public MatrixCalc(int x) {
        n = x;
        matrice = new int[n][n];
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
        System.out.print(u+"-");
        visited[u] = true;
        for (int i = 0; i < n; i++) {
            if (matrice[u][i] == 1)
                if (!visited[i])
                    parcurgere(i, visited);
        }
    }

    public void isConnected() {
        int nrComp = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            visited[i] = false;
        System.out.println("Graful tau are urmatoarele componente conexe: ");
        for (int i = 0; i < n; i++)
            if (!visited[i]) {
                parcurgere(i, visited);
                System.out.println();
                nrComp++;
            }


        if (nrComp == 1) {
            isConnected = true;
            System.out.println("Graful tau este conex!");
        } else
            System.out.println("Graful tau are " + nrComp + " componente conexe!");
    }

    public void bfs(int x) {
        int[][] matrix = new int[n][n]; //matricea arborelui
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            visited[i] = false; //initializam cu false
        visited[x] = true;
        int queue = 0, poz = 0, curent;
        int[] v = new int[n + 1];//acest vector va avea rol de lista, intrucat vom adauga in el elementele vizitate pentru a putea realiza bfs-ul

        for (int i = 0; i <= n; i++)//initializam tot cu -1
            v[i] = -1;
        v[0] = x;//punem pe prima pozitie din vectorul-lista nodul de la care incepem

        while (v[queue] != -1)//cat avem elemente in stiva
             {
            curent = v[queue];//copiem nodul curent din stiva
            for (int i = 0; i < n; i++)
                if (matrice[curent][i] == 1 && !visited[i]) {//vedem ce noduri au muchie cu nodul curent si care nu au fost vizitate inca
                    v[++poz] = i;//adaugam in stiva un nod "bun"
                    visited[i] = true;//il marcam vizitat
                    matrix[curent][i] = matrix[i][curent] = 1;//adaugam in matricea arborelui nodul cu muchia din arbore
                }
            queue++;//trecem la pozitia urmatoare din vectorul lista
        }
        System.out.println("Matricea de adiacenta a arborelui tau partial este:");
        for (int i = 0; i < n; i++) {
            {
                for (int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
        }
    }

    public void partialTree(int x) {
        if (n <= x) System.out.println("Nodul introdus nu exista!");
        else if (!isConnected)
            System.out.println("Graful tau nu este conex deci nu se poate genera un arbore partial");
        else bfs(x);
    }
}
