package com.company;
import Catalog.Catalog;
import Items.Book;
import Items.Song;
import java.nio.file.Paths;
import static Catalog.CatalogUtil.*;

public class Main {

    public static void main(String[] args) {
        Catalog catalog = new Catalog("Catalog1", "C:\\Users\\Marian\\Desktop\\Catalog.txt");
        Book Fram = new Book("Fram", Paths.get("C:\\Users\\Marian\\Desktop\\find.txt"), "Cezar Petrescu", 2000);
        Song LasaInima = new Song("Default", Paths.get("C:\\Users\\Marian\\Desktop\\lasa-inima-sa-zbiere-official-video.mp3"), "Smiley", 2021);
        catalog.addToCatalog(LasaInima);
        catalog.addToCatalog(Fram);
        play(Fram,catalog);
        play(LasaInima,catalog);
        list(catalog);
        save(catalog);
        list(catalog);
        Catalog catalogSecond = load("C:\\Users\\Marian\\Desktop\\Catalog.txt");
        list(catalogSecond);
        save(catalogSecond);
    }
}
