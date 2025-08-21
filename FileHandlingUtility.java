
import java.io.*;
import java.util.Scanner;

/**
 * FileHandlingUtility
 * ===================
 * A simple Java program to demonstrate:
 * 1. Reading text from a file
 * 2. Writing text to a file
 * 3. Modifying (appending) text in a file
 *
 * Author: Pawan Kumar Sharma
 * Date: 06-08-2025
 */

public class FileHandlingUtility {

    // Method to write data into a file
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Method to read data from a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify data into a file
    public static void modifyFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("\n" + content);
            System.out.println("Content modified successfully!");
        } catch (IOException e) {
            System.out.println("Error modifying to file: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "sample.txt"; // file name

        while (true) {
            System.out.println("\n===== File Handling Utility =====");
            System.out.println("1. Read from file");
            System.out.println("2. Write to file");
            System.out.println("3. Modify to file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    readFile(fileName);
                    break;
                    
                case 2:
                    System.out.print("Enter text to write: ");
                    String writeContent = scanner.nextLine();
                    writeFile(fileName, writeContent);
                    break;

                case 3:
                    System.out.print("Enter text to modify: ");
                    String modifyContent = scanner.nextLine();
                    modifyFile(fileName, modifyContent);
                    break;

                case 4:
                    System.out.println("Exiting File Handling Utility...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

