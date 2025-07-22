import java.sql.*;

public class UpdateMultipleCols {
    public static void main(String arg[]) throws SQLException {
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String userName = "intern2025";
        String password = "intern2025";
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USERS_HARIKA SET UPHONE=?,USER_EMAIL=? WHERE USERID='U2'");
        preparedStatement.setString(1,"9988775309");
        preparedStatement.setString(2,"jhonathon@gmail.com");
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM USERS_HARIKA");
        while(resultSet.next()){
            System.out.print(resultSet.getString(1)+" ");
            System.out.print(resultSet.getString(2)+ " ");
            System.out.print(resultSet.getString(3)+ " ");
            System.out.println(resultSet.getString(4));
        }
    }
}
