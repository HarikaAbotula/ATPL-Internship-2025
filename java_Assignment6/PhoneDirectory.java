package com.aaslin.assignments;
import java.util.*;
public class PhoneDirectory {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> phoneDirectory = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		while(true) {
			
			System.out.println(" Phone Directory ");
			System.out.println("1.Add Contact");
			System.out.println("2.Search Contact");
			System.out.println("3.Remove Contact");
			System.out.println("4.Exit");
			choice=scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
				case 1:
					System.out.println("Enter the contact name and phone number");
					String name = scanner.nextLine();
					System.out.println("Enter the phone number");
					String phoneNum = scanner.nextLine();
					phoneDirectory.put(name,phoneNum);
					break;
				case 2:
					System.out.println("Enter the name ,you want to search");
					name=scanner.nextLine();
					System.out.println("Contact:" +phoneDirectory.getOrDefault(name,"Not Found"));
					break;
				case 3:
					System.out.println("Enter the name ,you want to remove");
					name=scanner.nextLine();
					phoneDirectory.remove(name);
					System.out.println("Removed if existed");
					break;
				case 4:
					System.out.println("Exit");
					return;
				default:
					System.out.println("Invalid choice. Please try again");
					scanner.close();
			}
		}
	}
}

