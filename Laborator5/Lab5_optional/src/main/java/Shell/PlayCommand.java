package Shell;

import Catalog.Catalog;
import Items.Items;

import java.awt.*;
import java.io.File;

public class PlayCommand {

    public static void play(String name, Catalog catalog) {
        Boolean found=false;
        try {
            for (Items item : catalog.getCatalog()) {
                if (item.getName().equals(name) ) {
                    File file = new File(String.valueOf(catalog.getCatalog().get(catalog.getCatalog().indexOf(item)).getPath()));
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(file);
                    found=true;
                }
            }
            if(!found){
                throw new NoItemFoundException();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
