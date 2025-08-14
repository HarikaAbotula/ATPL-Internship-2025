package com.aaslin.beanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleMain {

	public static void main(String[] args) {
		System.out.println("Spring Container Initialised");
		
		// By using XML
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/aaslin/springcore/BeansLifeCycle.xml");
//		TeacherXml teacherXml = (TeacherXml) context.getBean("teacherXml");
//		teacherXml.customDestroy(); //should be called to print statement
//		System.out.println("Spring Container closed");
		
		//By using interface
//		ApplicationContext context1 = new ClassPathXmlApplicationContext("com/aaslin/springcore/BeansLifeCycle.xml");
//		TeacherInterface teacherInterface = (TeacherInterface) context1.getBean("teacherInterface");
//		teacherInterface.destroy();
//		System.out.println("Spring Container closed");	
		
		//by using Annotation
		ApplicationContext context2 = new AnnotationConfigApplicationContext("com/aaslin/springcore/BeansLifeCycle.xml");
		TeacherAnnotation teacherAnnotation = (TeacherAnnotation) context2.getBean("teacherAnnotation");
		teacherAnnotation.cleanup();
		System.out.println("Spring Container closed");	
	}

}
