package com.aaslin.springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class IocMain {

	public static void main(String[] args) {
		
//		System.out.println("------XML Based Configuration-----");
//		System.out.println("Using ApplicationContext");
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		
//		Student student = (Student)context.getBean("student");
//		student.display();
//		
//		College college = (College) context.getBean("college");
//		college.displayCollegeName();
//		
//		System.out.println(" \n Using BeanFactory");
//		Resource resource = new ClassPathResource("beans.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		Student studentBF = (Student)context.getBean("student");
//		studentBF.display();
//		
//		College collegeBF = (College) context.getBean("college");
//		collegeBF.displayCollegeName();
		
		System.out.println("------Java Based Configuration-----");
		System.out.println("Using ApplicationContext");
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigIoc.class);
		
		Student student = (Student)context.getBean("student");
		student.display();
		
		College college = (College) context.getBean("college");
		college.displayCollegeName();
		
	}

}
