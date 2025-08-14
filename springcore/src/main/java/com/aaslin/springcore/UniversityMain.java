package com.aaslin.springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class UniversityMain {
	public static void main(String args[]) {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//University university = (University) context.getBean("university");
		Resource resource = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		University university = (University) factory.getBean("university");
		university.showDetails();
	}
}
