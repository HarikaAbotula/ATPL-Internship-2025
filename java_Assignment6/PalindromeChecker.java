package com.aaslin.assignments;
import java.util.*;
public class PalindromeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Character> deque = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word");
		String word=scanner.nextLine().toLowerCase();
		char charArray[] = word.toCharArray();
		
		for(int index=0;index<charArray.length;index++) {
			deque.add(charArray[index]);
		}
		
		boolean isPalindrome=true;
		while(deque.size()>1) {
			if(deque.pollFirst()!= deque.pollLast()) {
				isPalindrome=false;
				break;
			}
		}
		
		 if(isPalindrome) {
	            System.out.println(word +" is a palindrome.");
	        } 
		 else {
	            System.out.println(word+ " is not a palindrome.");
	        }
		scanner.close();
	}
}
