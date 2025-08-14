package com.aaslin.springautowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiringMain {
	public static void main(String args[]) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/aaslin/springautowiring/AutowiringBeans.xml");
		EmployeeField field = (EmployeeField) context.getBean("employeeField");
		field.display();
		
		EmployeeSetter setter = (EmployeeSetter) context.getBean("employeeSetter");
		setter.display();
		
		EmployeeConstructor construct = (EmployeeConstructor) context.getBean("employeeConstructor");
		construct.display();
	}
}
