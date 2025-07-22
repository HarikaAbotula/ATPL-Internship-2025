import java.sql.*;

public class UpdateUserData {
    public static void main(String args[]) throws SQLException {
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String userName = "intern2025";
        String password = "intern2025";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE USERS_HARIKA SET USER_EMAIL='johnson@gmail.com' WHERE USERID='U1'");
        System.out.println("One record updated");

        statement.executeUpdate("UPDATE USERS_HARIKA SET UPHONE=7896543012 WHERE USERID='U1'");
        System.out.println("NEW record updated");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS_HARIKA");
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1)+ " ");
            System.out.print(resultSet.getString(2)+ " ");
            System.out.print(resultSet.getLong(3)+ " ");
            System.out.println(resultSet.getString(4));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
