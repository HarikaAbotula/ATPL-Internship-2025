import java.sql.*;
import java.util.Scanner;

public class SQLInjectionDemo {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String userName = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.next();

        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String query = "SELECT * FROM USERS_HARIKA WHERE USERNAME= '"+userName+"' AND PASSWORD= '"+password+"'";
        Connection connection = DriverManager.getConnection(url, "intern2025", "intern2025");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println(query);
        if(resultSet.next()){
            System.out.println("Valid Credentials");
        }
        else{
            System.out.println("Invalid credentials");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
