package com.aaslin.assignments;
import java.util.*;
public class CharacterCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String");
		String string=scanner.nextLine().toLowerCase();
		
		Map<Character,Integer> charCount = new HashMap<>();
		
		for(char character : string.toCharArray()) {
			charCount.put(character, charCount.getOrDefault(character,0)+1);
		}
		
		System.out.println("Character count of the given string");
		for(Map.Entry<Character,Integer> entry : charCount.entrySet()) {
			System.out.println(entry.getKey()+ " : "+ entry.getValue());
		}
		scanner.close();
	}
}
