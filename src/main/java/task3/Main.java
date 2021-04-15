package task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileCommander fc = new FileCommander();
        Scanner sc = new Scanner(System.in);

        greeting();

        do {
            String command = sc.nextLine();
            String[] commandArgs = command.split(" ");

            try {
                switch (commandArgs[0]) {
                    case ":q":
                        System.exit(0);
                    case "cd":
                        fc.getDir(commandArgs[1]);
                        break;
                    case "cat":
                        fc.readFile(commandArgs[1]);
                        break;
                    case "cp":
                        fc.copyFiles(commandArgs[1], commandArgs[2]);
                        break;
                    case "ls":
                        fc.listDir();
                        break;
                }
            } catch (Exception e) {
                System.err.println("Invalid arguments");
            }

            System.out.println("CURSOR at:" + fc.getRoot().getAbsolutePath());

        } while (sc.hasNextLine());
    }

    private static void greeting() {
        System.out.println("Supported commands:");
        System.out.println("cd ..");
        System.out.println("cd dir");
        System.out.println("ls");
        System.out.println("cat file");
        System.out.println("cp file1 file2");
        System.out.println(":q");
    }

}
