import java.sql.*;

public class InsertUserData {
    public static void main(String args[]) throws SQLException{
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String userName = "intern2025";
        String password = "intern2025";

        Connection connection = DriverManager.getConnection(url,userName,password);
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO USERS_HARIKA VALUES('U2','JOHN',1234567891,'john@gamil.com')");
        System.out.println("Successfully inserted a record");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS_HARIKA");
        while(resultSet.next()){
            System.out.print(resultSet.getString(1)+ " ");
            System.out.print(resultSet.getString(2)+ " ");
            System.out.print(resultSet.getLong(3)+ " ");
            System.out.println(resultSet.getString(4));

        }
        connection.close();
        statement.close();
        resultSet.close();
    }
}
