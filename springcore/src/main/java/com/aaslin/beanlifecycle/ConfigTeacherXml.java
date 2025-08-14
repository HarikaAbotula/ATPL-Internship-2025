package com.aaslin.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigTeacherXml {
	
	@Bean
	public TeacherXml teacherXml(){
		return new TeacherXml();
	}
	
	@Bean
	public TeacherInterface teacherInterface() {
		return new TeacherInterface();
	}
	
	@Bean
	public TeacherAnnotation teacherAnnotation() {
		return new TeacherAnnotation();
	}
}
