package com.aaslin.springinjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SetterInjectionMain {

	public static void main(String[] args) {
		
//		System.out.pritnln("----xml based configuration---");
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//Library library = (Library)context.getBean("library");
//		Resource resource = new ClassPathResource("beans.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		Library library = (Library)factory.getBean("library");
//		library.display();
		
		System.out.println("--Java Based Configuration--");
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigSetterInject.class);
		Library library = (Library)context.getBean("library");
		library.display();

	}

}
