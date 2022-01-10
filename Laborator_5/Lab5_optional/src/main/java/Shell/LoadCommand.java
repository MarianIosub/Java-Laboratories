package Shell;

import Catalog.Catalog;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadCommand {
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
        LoadCommand catalogUtil = new LoadCommand();
        Catalog catalog = (Catalog) catalogUtil.ReadObjectFromFile(path);
        return catalog;
    }
}
