package com.aaslin.springbootjdbcDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable= false)
	private String name;
	
	@Column(length=10,unique=true)
	private long phoneNum;
	
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student() {
		super();
	}
	public Student(int id, String name, long phoneNum, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	

}
