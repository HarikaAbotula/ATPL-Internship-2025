package com.aaslin.assignments;
import java.util.*;
public class SchedulerQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> queue = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of documents,you want to add");
		int size=scanner.nextInt();
		scanner.nextLine();
		
		for(int index=0;index<size;index++) {
			queue.offer(scanner.nextLine());
		}
		
		System.out.println("Enter the number of documents,you want to remove ");
		int removeDoc =scanner.nextInt();
		
		for(int index=0;index<removeDoc;index++) {
			String printedDoc = queue.poll();
            if (printedDoc != null) {
                System.out.println("Removed Document: " + printedDoc);
            }
            else {
                System.out.println("No more documents to print.");
            }
		}
		System.out.println("Remaining Print Queue: " + queue);
		scanner.close();
	}
}
