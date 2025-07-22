import java.sql.*;

public class BatchInsertPreparedStatement {
    public static void main(String arg[]) throws SQLException{
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String userName = "intern2025";
        String password = "intern2025";
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCTS_HARIKA (PRODUCT_ID,PRODUCT_NAME,PRICE) VALUES(?,?,?)");

        int[] productId = {105,106,107,108};
        String[] productName = {"WASHING MACHINE","OVEN","LAPTOP","Key board"};
        int[] price={8999,16000,56000,2999};

        for(int i=0;i<productId.length;i++){
            preparedStatement.setInt(1,productId[i]);
            preparedStatement.setString(2,productName[i]);
            preparedStatement.setInt(3,price[i]);
            preparedStatement.addBatch();
        }
        int[] result = preparedStatement.executeBatch();
        System.out.println("Batch inserted successfully");

        preparedStatement.close();
        connection.close();
    }
}
