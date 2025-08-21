package com.aaslin.library.dao;

import com.aaslin.library.model.User;
import com.aaslin.library.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

 // DAO class to handle CRUD operations for User.
 
public class UserDao {

    // Add a new user to the database.
     
    public boolean addUser(User user) {
        String sql = "INSERT INTO user_library (user_id, name, email, phone, address, is_active, created_date, created_by, updated_date, updated_by)"
                   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setBoolean(6, user.isActive());
            ps.setTimestamp(7, new Timestamp(user.getCreatedDate().getTime()));
            ps.setString(8, user.getCreatedBy());
            ps.setTimestamp(9, new Timestamp(user.getUpdatedDate().getTime()));
            ps.setString(10, user.getUpdatedBy());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve all active users.
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user_library WHERE is_active = TRUE";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setActive(rs.getBoolean("is_active"));
                user.setCreatedDate(rs.getTimestamp("created_date"));
                user.setCreatedBy(rs.getString("created_by"));
                user.setUpdatedDate(rs.getTimestamp("updated_date"));
                user.setUpdatedBy(rs.getString("updated_by"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Soft delete a user by setting is_active = false.
     
    public boolean softDeleteUser(int userId, String updatedBy) {
        String sql = "UPDATE user_library SET is_active = FALSE, updated_date = NOW(), updated_by = ? WHERE user_id = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, updatedBy);
            ps.setInt(2, userId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
