import java.sql.*;
import java.util.Scanner;

public class SQLInjectionDemo {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/interndb", "root", "database@01");
        //vulnerable statement ,leads to sql injection
        Statement statement = con.createStatement();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        //If user enters: username = admin(anything), password = ' OR '1'='1
        // The final query becomes:
        // SELECT * FROM users WHERE username = 'admin' AND password = '' OR '1'='1'
        // '1'='1' is always true, attacker logs in without valid password!
        String query = "SELECT * FROM users_harika WHERE username = '" + username + "' AND password = '" + password + "'";
        System.out.println("Executing: " + query);

        ResultSet resultSet = stmt.executeQuery(query);

        if (resultSet.next()) {
            System.out.println(" Login Successful! Welcome " + resultSet.getString("username"));
        } else {
            System.out.println(" Invalid credentials");
        }

        scanner.close();
        resultSet.close();
        statement.close();
        connection.close();
    }
}
