public class Director extends Person{
    public Director(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                '}';
    }
}
