package com.aaslin.assignments;

import java.io.*;
import java.util.Scanner;

public class SimpleEncryptDecrypt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFile = "encrypted.txt";

        while (true) {
            System.out.println("\n1. Encrypt and Save Message");
            System.out.println("2. Decrypt and Display Message");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter the message to encrypt: ");
                        String message = scanner.nextLine();
                        String encrypted = encrypt(message);
                        writeToFile(inputFile, encrypted);
                        System.out.println("Message encrypted and saved to '" + inputFile);
                        break;

                    case 2:
                        String encryptedMessage = readFromFile(inputFile);
                        String decrypted = decrypt(encryptedMessage);
                        System.out.println("Original message after decryption: " + decrypted);
                        break;

                    case 3:
                        System.out.println("Exited.");
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }

            } 
            catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a number (1, 2 or 3).");
            } 
            catch (IOException e) {
                System.err.println("I/O Error: " + e.getMessage());
            }
        }

       // scanner.close();
    }

    // Encrypt by shifting characters by +3
    public static String encrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            result.append((char)(ch + 3));
        }
        return result.toString();
    }

    // Decrypt by shifting characters by -3
    public static String decrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            result.append((char)(ch - 3));
        }
        return result.toString();
    }

    // Write encrypted message to file
    public static void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    // Read encrypted message from file
    public static String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}
