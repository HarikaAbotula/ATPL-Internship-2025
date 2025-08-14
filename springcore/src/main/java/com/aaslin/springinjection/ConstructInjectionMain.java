package com.aaslin.springinjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ConstructInjectionMain {

	public static void main(String[] args) {
		
//		System.out.println("XML Based Configuartion");
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); loads eagerly
//		Resource resource = new ClassPathResource("beans.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		Faculty faculty = (Faculty)factory.getBean("faculty");
//		faculty.showDetails();
		
		System.out.println("---Java Based Configuartion---");
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigConstructorInjection.class);
		Faculty faculty = (Faculty)context.getBean("faculty");
		faculty.showDetails();
	}

}
