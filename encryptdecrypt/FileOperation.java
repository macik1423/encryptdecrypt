package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class FileOperation {

    public static String readFile(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + fileName);
        }
        return "";
    }

    public static void writeFile(String fileName, String text) {
        File file = new File(fileName);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(text);
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

}
