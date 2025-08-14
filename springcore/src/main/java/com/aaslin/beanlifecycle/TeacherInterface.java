package com.aaslin.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TeacherInterface implements InitializingBean, DisposableBean{
	
	public TeacherInterface() {
        System.out.println("TeacherInterface Constructor created");
    }
	
	@Override
	public void afterPropertiesSet() {
		 System.out.println("InitializingBean: afterPropertiesSet() called");
	}

	@Override
	public void destroy() {
		System.out.println("DisposableBean: destroy() called");
	}
}
