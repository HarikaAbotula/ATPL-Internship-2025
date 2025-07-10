package com.aaslin.assignments;
import java.util.*;
public class DuplicateRemover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the number of elements:");
		 int size = scanner.nextInt();
		 
		 List<Integer> numbers= new ArrayList<>();
		 
		 for(int index=0;index<size;index++) {
			 numbers.add(scanner.nextInt());
		 }
		 
		 Set<Integer> uniqueSet = new HashSet<>(numbers);
		 
		 List<Integer> uniqueList = new ArrayList<>(uniqueSet);//convert set to list
		 
		 System.out.println("Unique numbers after duplicates removed:");
	        for (int index = 0; index < uniqueList.size(); index++) {
	            System.out.print(uniqueList.get(index) + " ");
	        }
	     scanner.close();
	}

}
