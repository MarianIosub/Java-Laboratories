package Shell;

import Catalog.Catalog;
import Items.Book;
import Items.Song;

import java.util.Scanner;

public class AddCommand {


    public static void add(Catalog catalog, String typeOfItem) {
        Scanner scanner = new Scanner(System.in);
        switch (typeOfItem) {
            case "song": {
                System.out.println("You decided to add a song! You have to insert the followings:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("\nPath: ");
                String path = scanner.nextLine();
                System.out.print("\nName of artist: ");
                String artist = scanner.nextLine();
                System.out.print("\nRelease year: ");
                Integer year = Integer.valueOf(scanner.nextLine());
                Song newSong = new Song(name, path, artist, year);
                catalog.addToCatalog(newSong);
                System.out.println("\n You added the song: " + newSong);

            }
            case "book": {
                System.out.println("You decided to add a book! You have to insert the followings:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("\nPath: ");
                String path = scanner.nextLine();
                System.out.print("\nName of author: ");
                String artist = scanner.nextLine();
                System.out.print("\nRelease year: ");
                Integer year = Integer.valueOf(scanner.nextLine());
                Book newBook = new Book(name, path, artist, year);
                catalog.addToCatalog(newBook);
                System.out.println("\n You added the book: " + newBook);
            }
        }
    }
}
