package Items;
import java.io.Serializable;
import java.nio.file.Path;

public abstract class Items implements Serializable{
    public String name;
    public String path;


    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
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
