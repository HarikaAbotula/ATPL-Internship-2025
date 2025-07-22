import java.sql.*;

public class LikeClause {
    public static void main(String arg[]) throws SQLException {
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String userName = "intern2025";
        String password = "intern2025";
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS_HARIKA WHERE PRODUCT_NAME LIKE ?");
        preparedStatement.setString(1, "%phone%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString(2));
        }
        preparedStatement.close();
        connection.close();
    }
}
