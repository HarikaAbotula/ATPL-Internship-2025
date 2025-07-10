package com.aaslin.assignments;
import java.util.*;
public class UniqueWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine().toLowerCase();
        String[] words = sentence.split("\\s+");
        
        Set<String> uniqueWords = new HashSet<>();
        
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            word = word.replaceAll("[^a-zA-Z0-9]", ""); // remove punctuation
            if (!word.isEmpty()) {
                uniqueWords.add(word);
            }
        }
        
        System.out.println("Unique words:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        scanner.close();
	}

}
