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
        System.out.println(file);

        try (Scanner sc = new Scanner(new File("C:\\Users\\ASCII_Cow\\MooFolder\\MooFile.txt"))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
