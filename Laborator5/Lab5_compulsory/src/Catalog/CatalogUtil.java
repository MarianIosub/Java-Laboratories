package Catalog;

import Items.Items;

import java.awt.*;
import java.io.*;

public class CatalogUtil {


    public static void play(Items item, Catalog catalog) {
        try {
            File file = new File(String.valueOf(catalog.getCatalog().get(catalog.getCatalog().indexOf(item)).getPath()));
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void list(Catalog catalog) {
        System.out.println(catalog);
    }

    private void WriteObjectToFile(String path, Object o) {

        try {

            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(o);
            objectOut.close();
            System.out.println("The Object was saved to the file.");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void save(Catalog catalog) {
        CatalogUtil catalogUtil = new CatalogUtil();
        catalogUtil.WriteObjectToFile(catalog.getPath(), catalog);

    }

    private Object ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            System.out.println("The Object has been loaded successfully.");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Catalog load(String path) {
        CatalogUtil catalogUtil = new CatalogUtil();
        Catalog catalog = (Catalog) catalogUtil.ReadObjectFromFile(path);
        return catalog;
    }

}
