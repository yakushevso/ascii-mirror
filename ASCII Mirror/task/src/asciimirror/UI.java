package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UI {
    public void start() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Input the file path:");
            List<String> animal = readFile(sc.nextLine());
            int longestLine = getLongestLine(animal);
            modifiedPrint(animal, longestLine);
        }
    }

    private List<String> readFile(String file) {
        List<String> list = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                list.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return list;
    }

    private int getLongestLine(List<String> animal) {
        int longestLine = 0;

        for (String line : animal) {
            if (line.length() > longestLine) {
                longestLine = line.length();
            }
        }

        return longestLine;
    }

    private String getModifiedLine(String line, int longestLine) {
        return line.length() <= longestLine ? line + " ".repeat(longestLine - line.length()) : line;
    }

    private String getReversedModifiedLine(String line) {
        StringBuilder reverseLine = new StringBuilder();
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('<', '>');
        charMap.put('>', '<');
        charMap.put('[', ']');
        charMap.put(']', '[');
        charMap.put('{', '}');
        charMap.put('}', '{');
        charMap.put('(', ')');
        charMap.put(')', '(');
        charMap.put('/', '\\');
        charMap.put('\\', '/');

        for (int i = line.length() - 1; i >= 0; i--) {
            char ch = line.charAt(i);
            reverseLine.append(charMap.getOrDefault(ch, ch));
        }

        return reverseLine.toString();
    }

    private void modifiedPrint(List<String> animal, int longestLine) {
        for (String line : animal) {
            String modifiedLine = getModifiedLine(line, longestLine);
            System.out.println(modifiedLine + " | " + getReversedModifiedLine(modifiedLine));
        }
    }
}
