package Items;
import java.io.Serializable;
import java.nio.file.Path;

public abstract class Items {
    public String name;
    public Path path;


    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", path=" + path +
                '}';
    }
}
