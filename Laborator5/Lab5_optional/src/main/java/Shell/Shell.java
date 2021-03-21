package Shell;

import Catalog.Catalog;



import java.io.IOException;
import java.util.Scanner;

public class Shell {


    public static void getInput() {
        Catalog catalog = null;
        while (true) {

            System.out.print("Please input your command: ");
            String command;
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            System.out.println();
            String[] splitCommand = command.split(" ");
            try {
                if (!splitCommand[0].equals("report") && !splitCommand[0].equals("exit") && !splitCommand[0].equals("load") && !splitCommand[0].equals("play") && !splitCommand[0].equals("add") && !splitCommand[0].equals("save") && !splitCommand[0].equals("list")) {
                    throw new InvalidCommandException();
                }
                command = splitCommand[0];
            } catch (Exception exception) {
                System.out.println(exception.getMessage());

            }

            switch (command) {
                case "list": {
                    try {
                        if (catalog == null) {
                            throw new InvalidCatalogException();
                        }
                        ListCommand.list(catalog);
                        continue;
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                        continue;
                    }
                }
                case "load": {
                    try {
                        if (splitCommand[1].equals(null)) {
                            throw new InvalidCommandException();
                        }
                        catalog = LoadCommand.load(splitCommand[1]);
                        System.out.println("You have loaded the catalog: " + catalog);
                        continue;
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
                case "play": {
                    try {
                        if (catalog == null) {
                            throw new InvalidCatalogException();
                        }
                        PlayCommand.play(splitCommand[1], catalog);
                        continue;
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                        continue;
                    }
                }
                case "exit": {
                    System.out.println("You've exited successfully!");
                    System.exit(0);
                }
                case "save": {
                    try {
                        if (catalog == null) {
                            throw new InvalidCatalogException();
                        }
                        SaveCommand.save(catalog);
                        continue;
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                        continue;
                    }
                }
                case "add": {
                    if (!splitCommand[1].equals("song") && !splitCommand[1].equals("book")) {
                        System.out.println("You can add or a song, or a book, not a " + splitCommand[1] + ". Try again please!");
                    } else {
                        AddCommand.add(catalog, splitCommand[1]);
                    }
                }
                case "report":{
                    try {
                        ReportCommand.getReport(catalog);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
            }
        }
    }
}


