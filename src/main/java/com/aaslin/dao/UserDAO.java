package com.aaslin.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aaslin.model.User;
import com.aaslin.util.DbUtil;

public class UserDAO {
	 //Get User into based on parameter(id)
	public User getUserById(int id) throws SQLException {
	        
		String query = "SELECT * FROM UserServlet_Harika WHERE userId = ?";
	        
	        try (Connection connection = DbUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	System.out.println("Connection established");
	        	preparedStatement.setInt(1, id);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                return new User(resultSet.getInt("userId"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("age"));
	            } 
	            else {
	                return null;
	            }
	        }
	    }
	
	//to store information in DB
	public void insertUserIntoDb(int userId,String username,String password,int age) throws SQLException {
		String query="INSERT INTO UserServlet_Harika values(?,?,?,?)";
		try(Connection connection = DbUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query)){
			 
			ps.setInt(1, userId);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setInt(4, age);
			
			ps.executeUpdate();
		}
	}
	
	// to print all user info
	public List<User> getAllUserInfo() throws SQLException {
		 
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM UserServlet_Harika";
	        
	        try (Connection connection = DbUtil.getConnection();
	        		Statement stmt = connection.createStatement();
	                ResultSet rs = stmt.executeQuery(query)) {
	        	while (rs.next()) {
	                users.add(new User(rs.getInt("userId"),rs.getString("username"),rs.getString("password"),rs.getInt("age")));
	        	}
	        }
	        return users;
	}
}
