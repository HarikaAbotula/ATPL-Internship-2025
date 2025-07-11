package com.aaslin.assignments;
import java.util.*;
public class TaskScheduler {
	
	 Map<String, Queue<String>> taskMap = new HashMap<>();
	 
	 public void addTask(String day,String task) {
		taskMap.putIfAbsent(day,new LinkedList<>());
		taskMap.get(day).add(task);
		System.out.println("Task added to "+day+": "+task);
	}
	 
	//view all tasks for specific day
	public void viewTask(String day) {
		Queue<String> tasks = taskMap.get(day);
		if(tasks == null || tasks.isEmpty()) {
			System.out.println("No tasks scheduled for : "+day);
		}
		System.out.println("Task for "+day+": "+tasks);
	}
	
	//remove tasks
	public void removeTask(String day,String task) {
		if(!taskMap.containsKey(day)) {
			System.out.println(day+" not found.");
			return;
		}
		boolean removed = taskMap.get(day).remove(task);
		if(removed) {
			System.out.println(task +" removed from "+day);
		}
		else {
			System.out.println(task+" not found for "+day);
		}
	}

	public static void main(String[] args) {
		
		TaskScheduler taskscheduler = new TaskScheduler();
		//add tasks
		taskscheduler.addTask("Monday","Work on the topics of Java");
		taskscheduler.addTask("Monday","Submit the Assignment");
		taskscheduler.addTask("Tuesday","Attend the team meeting");
		taskscheduler.addTask("Wednesday","Learn New Topic");
		taskscheduler.addTask("Thursday","Visit Baba Temple at evng");
		
		//view tasks on specific day
		taskscheduler.viewTask("Monday");
		
		//remove tasks
		taskscheduler.removeTask("Tuesday","Attend the team meeting");	
	}
}
