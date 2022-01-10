public class Actor extends Person {
    public Actor(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }
}
