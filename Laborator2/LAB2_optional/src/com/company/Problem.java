package com.company;

/**
 * This is the definition of the class Problem
 */
public class Problem {
    public Source[] sources;
    public Destination[] destinations;
    public int nrSources;
    public int nrDestinations;
    public int[][] matrice;

    /**
     * Creates a new object of type Problem with number of sources, destinations
     * and two arrays of sources and destinations
     */
    Problem() {
        nrSources = 0;
        nrDestinations = 0;
        sources = new Source[1000];
        destinations = new Destination[1000];

    }

    /**
     * This methods adds a source in the problem
     * only if the object is not already in the array
     *
     * @param source is a given source object
     */
    public void addSource(Source source) {
        int ok = 0;
        for (int i = 0; i < nrSources; i++)
            if (sources[i].equals(source)) {
                System.out.println("Sursa introdusa are deja un duplicat!");
                ok = 1;
            }

        if (ok == 0)
            sources[nrSources++] = source;


    }

    /**
     * This methods adds a destination in the problem
     * only if the object is not already in the array
     *
     * @param destination is a given destination object
     */
    public void addDestination(Destination destination) {
        int ok = 0;
        for (int i = 0; i < nrDestinations; i++)
            if (destinations[i].equals(destination)) {
                System.out.println("Destinatia introdusa are deja un duplicat!");
                ok = 1;
            }

        if (ok == 0)
            destinations[nrDestinations++] = destination;


    }

    /**
     * This method prints the instance of the problem
     */
    public void getMatrice() {
        System.out.println("The instance of the problem is:\n");

        System.out.print("        ");
        for (int i = 0; i < nrDestinations; i++)
            System.out.print(destinations[i].getName() + "  ");
        System.out.println("Supply");
        for (int i = 0; i < nrSources; i++) {
            System.out.print("    " + sources[i].getName() + "   ");
            for (int j = 0; j < nrDestinations; j++)
                System.out.print(matrice[i][j] + "   ");
            System.out.println(" " + sources[i].getCapacity());
        }
        System.out.print("Demand  ");
        for (int j = 0; j < nrDestinations; j++)
            System.out.print(destinations[j].getComodities() + "  ");
        System.out.println("\n\n");
    }

    /**
     * @return the number of destinations of the problem
     */
    public int getNrDestinations() {
        return nrDestinations;
    }

    /**
     * @return the number of sources of the problem
     */
    public int getNrSources() {
        return nrSources;
    }

    /**
     * This methods sets the costs matrix for the problem
     *
     * @param matrice is a given matrix of costs for the problem
     */
    public void setMatrice(int[][] matrice) {
        this.matrice = new int[nrSources][nrDestinations];
        for (int i = 0; i < nrSources; i++)
            for (int j = 0; j < nrDestinations; j++)
                this.matrice[i][j] = matrice[i][j];
    }


}
