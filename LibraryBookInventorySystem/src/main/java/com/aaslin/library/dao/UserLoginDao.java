package com.aaslin.library.dao;

import java.sql.*;
import com.aaslin.library.util.DbUtil;

public class UserLoginDao {

    // Returns the role (admin/user) if valid, otherwise null
    public String validateUser(String username, String password) {
        String sql = "SELECT role FROM user_login WHERE username = ? AND password = ? AND is_active = TRUE";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("role"); // e.g., "admin" or "user"
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
