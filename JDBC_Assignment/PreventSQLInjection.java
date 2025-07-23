import java.sql.*;
import java.util.Scanner;

public class PreventSQLInjection {
    public static void main(String args[])throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/interndb", "root", "database@01");
        //This avoids direct concatenation and prevents SQL Injection
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS_HARIKA WHERE USERNAME = ? AND PASSWORD = ?");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        //Inputs are treated as values, not SQL code
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Login Successful! Welcome " + resultSet.getString("username"));
        } else {
            System.out.println("Invalid credentials");
        }
        scanner.close();
        resultSet.close();
        preparedStatement.close();
    }
}
