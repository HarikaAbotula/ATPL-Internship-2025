package com.aaslin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static final String db_url = "jdbc:mysql://192.168.71.15:3306/intern";
    private static final String db_user ="intern2025";
    private static final String db_password= "intern2025";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found", e);
        }
        return DriverManager.getConnection(db_url, db_user, db_password);
    }
    
}
