package Shell;

import Catalog.Catalog;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveCommand {
    private static void WriteObjectToFile(String path, Object o) {

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

        SaveCommand.WriteObjectToFile(catalog.getPath(), catalog);

    }
}
