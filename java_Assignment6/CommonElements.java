package com.aaslin.assignments;
import java.util.*;
public class CommonElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the number of elements for set1:");
		 int size1 = scanner.nextInt();
		 
		 Set<Integer> set1 = new HashSet<>();
		 
		 for(int index=0;index<size1;index++) {
			 set1.add(scanner.nextInt());
		 }
		 
		 System.out.println("Enter the number of elements for set2:");
		 int size2 = scanner.nextInt();
		 
		 Set<Integer> set2 = new HashSet<>();
		 
		 for(int index=0;index<size2;index++) {
			 set2.add(scanner.nextInt());
		 }
		 
		 Set<Integer> intersection = new HashSet<>(set1);
	     Set<Integer> union = new HashSet<>(set1);
	     Set<Integer> difference = new HashSet<>(set1);
	     
	     intersection.retainAll(set2);  
	     union.addAll(set2);          
	     difference.removeAll(set2); 
	     
	     System.out.println("\nSet 1: " + set1);
	     System.out.println("Set 2: " + set2);
	     
	     System.out.println("\nIntersection: " + intersection);
	     System.out.println("Union: " + union);
	     System.out.println("Difference (Set1 - Set2): " + difference);

		 scanner.close();
		 
		 
	}

}
