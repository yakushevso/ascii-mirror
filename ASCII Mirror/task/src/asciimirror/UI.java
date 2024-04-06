package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UI {
    public void start() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Input the file path:");
            readFile(sc.nextLine());
        }
    }

    public void readFile(String file) {
        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
