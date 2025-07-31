package com.aaslin.model;

public class User {
	private int userId;
    private String userName;
    private String password;
    private int age;

    //like JDBC often create objects dynamically using reflection.So, they require a default constructor.
    //Once the object is created, the tool sets the values using setters.
    public User() {} 
    
    public User(int userId, String userName, String password, int age) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    //allow other classes (like the DAO or servlet) to read the values of private fields.
    public int getId() {
    	return userId; 
    }
    public String getName() { 
    	return userName; 
    }
    public String getPassword() {
    	return password;
    }
    public int getAge() {
    	return age; 
    }

    //allow other classes to set or update the values of private fields
    public void setId(int userId) { 
    	this.userId = userId; 
    }
    public void setName(String userName) { 
    	this.userName = userName; 
    }
    public void setPassword(String password) {
    	this.password=password;
    }
    public void setAge(int age) { 
    	this.age = age; 
    }

    public String toString() {
        return "User [ID=" + userId + ", UserName=" + userName + "Password= "+ password + ", Age=" + age + "]";
    }
}
