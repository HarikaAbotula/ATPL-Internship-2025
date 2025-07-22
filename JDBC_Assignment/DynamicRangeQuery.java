import java.sql.*;

public class DynamicRangeQuery {
    public static void main(String arg[]) throws SQLException {
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String userName = "intern2025";
        String password = "intern2025";
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS_HARIKA WHERE PRICE BETWEEN ? AND ?");
        preparedStatement.setDouble(1, 3999.00);
        preparedStatement.setInt(2, 9999);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
    }
}
