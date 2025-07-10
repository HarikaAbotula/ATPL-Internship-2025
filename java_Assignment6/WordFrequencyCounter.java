package com.aaslin.assignments;
import java.util.*;
public class WordFrequencyCounter{
	public static void main(String args[]) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the paragraph: ");
		String paragraph=scanner.nextLine();
		//converts paragraph to lower case and removes all characters expect a-z by space.
		String[] words = paragraph.toLowerCase().replaceAll("[^a-z ]","").split(" ");
		
		Map<String,Integer> freqMap = new HashMap<>();
		
		for(String word:words) {
			freqMap.put(word, freqMap.getOrDefault(word,0)+1);
		}
		
		System.out.println("Word Frequencies: ");
		for(Map.Entry<String,Integer> entry : freqMap.entrySet()) {
			System.out.println(entry.getKey()+ " : " +entry.getValue());
		}
		scanner.close();
	}
}