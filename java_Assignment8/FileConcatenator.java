package com.aaslin.assignments;

import java.io.*;

public class FileConcatenator {

    public static void main(String[] args) {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String outputFile = "concatenated.txt";

        try (
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            // Read from file1.txt and write to concatenated.txt
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // Read from file2.txt and append to concatenated.txt
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files concatenated successfully into '" + outputFile);

        } 
        catch (FileNotFoundException e) {
            System.err.println("One of the input files was not found: " + e.getMessage());
        } 
        catch (IOException e) {
            System.err.println("An error occurred during file I/O: " + e.getMessage());
        }
    }
}


