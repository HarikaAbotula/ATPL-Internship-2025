package com.aaslin.assignments;

import java.io.*;
import java.util.*;

public class FileWordFrequencyCounter {

    public static void main(String[] args) {
        String inputFileName = "inputfile.txt";
        String outputFileName = "word_frequencies.txt";

        Map<String, Integer> wordCount = new HashMap<>();

        // Step 1: Read input.txt and count word frequencies
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } 
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Step 2: Sort entries by frequency (descending) using Comparator class
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());

        Collections.sort(sortedList, new FrequencyComparator());

        // Step 3: Write to word_frequencies.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, Integer> entry : sortedList) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Word frequencies written to '" + outputFileName + "'.");

        } 
        catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // Custom Comparator for descending order
    static class FrequencyComparator implements Comparator<Map.Entry<String, Integer>> {
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            return e2.getValue().compareTo(e1.getValue());
        }
    }
}
