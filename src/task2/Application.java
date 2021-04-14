package task2;

import task2.data.Pudge;

import java.io.*;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Application {

    final private String fileName = "pudge.bin";
    final private String resourcePath = "resource/translation/Translation";

    private ResourceBundle resourceBundle;
    private Pudge pudge;

    Application(String language, String country) {
        Locale lc = new Locale(language, country);
        try {
            resourceBundle = ResourceBundle.getBundle(resourcePath, lc);
        } catch (MissingResourceException e) {
            try {
                resourceBundle = ResourceBundle.getBundle(resourcePath);
            } catch (Exception ex) {
                System.err.println("Resources are not loaded");
                System.exit(1);
            }
        } catch (Exception e) {
            System.err.println("Resources are not loaded");
            System.exit(2);
        }
        run();
    }

    void run() {
        printMenu();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        actionCreate();
                        break;
                    case 2:
                        actionSave();
                        break;
                    case 3:
                        actionLoad();
                        break;
                    case 4:
                        return;
                    default:
                        System.err.println("Input correct menu item");
                }
            } else {
                System.err.println("Input correct menu item");
                sc.next();
            }

            printPudge();
            printMenu();
        }
    }

    void printMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println(resourceBundle.getString("menu_menu"));
        System.out.println("1. " + resourceBundle.getString("menu_create"));
        System.out.println("2. " + resourceBundle.getString("menu_save"));
        System.out.println("3. " + resourceBundle.getString("menu_load"));
        System.out.println("4. " + resourceBundle.getString("menu_exit"));
    }

    void printPudge() {
        if (pudge != null) {
            System.out.println("--------------------------------------------------");
            System.out.println("Object in memory: " + pudge.toString());
        }
    }

    void actionCreate() {
        System.out.println("Enter pudge properties in format: int,int,int,string");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] pudgeArgs = sc.nextLine().split(",");

            try {
                if (pudgeArgs.length == 4) {
                    pudge = new Pudge(
                            Integer.parseInt(pudgeArgs[0]),
                            Integer.parseInt(pudgeArgs[1]),
                            Integer.parseInt(pudgeArgs[2]),
                            pudgeArgs[3]
                    );
                    System.out.println("Pudge created");
                    break;
                } else {
                    System.err.println("Try one more time");
                }
            } catch (Exception e) {
                System.err.println("Invalid input arguments");
            }

        }
    }

    void actionSave() {
        if (pudge == null) {
            System.out.println("Nothing to save");
            return;
        }

        try (
                FileOutputStream fos = new FileOutputStream(new File(fileName));
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(pudge);
            System.out.println("Pudge saved");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void actionLoad() {
        try (
                FileInputStream fis = new FileInputStream(new File(fileName));
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            pudge = (Pudge) ois.readObject();
            System.out.println("Pudge loaded");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
