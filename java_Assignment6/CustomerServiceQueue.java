package com.aaslin.assignments;
import java.util.*;
public class CustomerServiceQueue {
	
	Queue<String> customerQueue = new LinkedList<>();
	
		public void addCustomer(String name) {
	        customerQueue.offer(name);
	        System.out.println(name + " has been added to the queue.");
	        }
		
		public void serveCustomer() {
			if(customerQueue.isEmpty()) {
				System.out.println("No Customers to serve");
			}
			else {
				System.out.println("Serving Customer: "+customerQueue.poll());
			}
		}
		
		public void peekNextCustomer() {
			if (customerQueue.isEmpty()) {
	            System.out.println("No customers in the queue.");
	        } 
			else {
	            System.out.println("Next customer to be served: " + customerQueue.peek());
	        }
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerServiceQueue service = new CustomerServiceQueue();
		Scanner scanner = new Scanner(System.in);
		int choice; 
		
		while(true) {
			System.out.println("Customer Service Menu");
			System.out.println("1.Add customer into the service queue");
			System.out.println("2.Serve the customer");
			System.out.println("3.Find customer at top");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			
			choice=scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
            			case 1:
                			System.out.println("Enter Customer Name");
                			String name = scanner.nextLine();
               				service.addCustomer(name);  
                			break;

            			case 2:
               				service.serveCustomer();
                			break;

            			case 3:
                			service.peekNextCustomer();
                			break;

            			case 4:
                			System.out.println("Exiting customer service simulation");
                			return;

           			 default:
                			System.out.println("Invalid choice. Please try again.");
                			scanner.close();
			}
		}
	}
}
