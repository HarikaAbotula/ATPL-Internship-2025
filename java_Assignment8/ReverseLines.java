package com.aaslin.assignments;

import java.io.*;

public class ReverseLines {

    public static void main(String[] args) {
        String inputFile = "inputlines.txt";
        String outputFile = "reversed.txt";

        try ( BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) 
        {
            String line;

            while ((line = reader.readLine()) != null) {
                // Reverse the line only if it's not null
                String reversedLine = new StringBuilder(line).reverse().toString();
                writer.write(reversedLine);
                writer.newLine(); 
            }

            System.out.println("Lines reversed and written to '" + outputFile + "'.");

        } 
        catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println("An error occurred during file I/O: " + e.getMessage());
        }
    }
}


