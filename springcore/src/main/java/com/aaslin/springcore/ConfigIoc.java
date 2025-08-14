package com.aaslin.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigIoc {
	
	@Bean
	public Student student() {
		Student student =new Student();
		student.setName("harika");
		return student;
	}
	
	@Bean
	public College college() {
		College college = new College();
		college.setCollegeName("MVGR");
		return college;
	}
	
}
