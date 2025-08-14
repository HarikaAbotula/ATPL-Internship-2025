package com.aaslin.springscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBeanScope {

	public static void main(String[] args) {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("BeansLifeCycle.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBeanScope.class);
		SingletonBean singletonBean =(SingletonBean)context.getBean("singletonBean");
		SingletonBean singletonBean1 =(SingletonBean) context.getBean("singletonBean");
		System.out.println(singletonBean==singletonBean1); //true
		System.out.println(singletonBean.hashCode());
		System.out.println(singletonBean1.hashCode());
		
//		System.out.println("--Java Based Configuration--");
//		ApplicationContext context1 = new AnnotationConfigApplicationContext(ConfigBeanScope.class);
//		PrototypeBean prototypeBean = (PrototypeBean)context1.getBean("prototypeBean");
//		PrototypeBean prototypeBean1 = (PrototypeBean)context1.getBean("prototypeBean");
//		System.out.println(prototypeBean==prototypeBean1);
//		System.out.println(prototypeBean.hashCode());
//		System.out.println(prototypeBean1.hashCode());
	}

}
