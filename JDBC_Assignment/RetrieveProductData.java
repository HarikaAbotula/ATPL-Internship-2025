import java.sql.*;

public class RetrieveProductData {
    public static void main(String args[]){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String userName = "intern2025";
        String password = "intern2025";

        try(Connection connection = DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS_HARIKA");
            ) {
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2)+" "+resultSet.getInt(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
