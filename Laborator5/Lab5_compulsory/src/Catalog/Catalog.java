package Catalog;


import Items.Items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    String name;
    List<Items> catalog;
    String path;

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
        this.catalog = new ArrayList<Items>();
    }

    public String getPath() {
        return path;
    }

    public List<Items> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Items> catalog) {
        this.catalog = catalog;
    }

    public void addToCatalog(Items item) {
        catalog.add(item);
    }

    @Override
    public String toString() {
        return "Catalog " +
                "named '" + name + '\'' +
                ", having path '" + path + '\'' +
                " contains the elements: " + catalog +
                '}';
    }
}
