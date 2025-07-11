package com.aaslin.assignments;
import java.util.*;
class Employee{
	String empName;
	int salary;
	
	Employee(String empName,int salary){
		this.empName=empName;
		this.salary=salary;
	}
	
	public int getSalary() {
		return salary;
	}	
	
	public String toString(){
		return  "Employee{name= " + empName + ", salary=" + salary + "}";
	}
}
public class EmployeeSalaryIterator {

	public static void main(String[] args) {

		List<Employee> employeelist = new ArrayList<>();
		employeelist.add(new Employee("John",20000));
		employeelist.add(new Employee("Lessie",15000));
		employeelist.add(new Employee("Ron",10000));
		employeelist.add(new Employee("Dustin",35000));
		employeelist.add(new Employee("Maxi",42000));
		
		Iterator<Employee> iterator = employeelist.iterator();
		
		while(iterator.hasNext()) {
			Employee employee = iterator.next();
			if(employee.getSalary() < 30000) {
				iterator.remove();
			}
		}
	System.out.println("List of Employees after removing those whose salary less than 30000 "+employeelist);		
	}
}
