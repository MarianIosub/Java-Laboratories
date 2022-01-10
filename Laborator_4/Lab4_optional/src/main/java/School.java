
public class School implements Comparable<School> {
    private String name;
    private int capacity;

    public School(String name) {
        this.name = name;
        this.capacity = 0;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public int compareTo(School o) {
        return this.getName().compareTo(o.getName());

    }
}
