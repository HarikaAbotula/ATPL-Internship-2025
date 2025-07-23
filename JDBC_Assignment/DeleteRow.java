import java.sql.*;

public class DeleteRow {
    public static void main(String args[])throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/interndb", "root", "database@01");
        String date= "2024-08-24";
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUCTS_HARIKA WHERE WARRANTY_DATE < ?");
        preparedStatement.setDate(1, Date.valueOf(date));
        int rowsDeleted=preparedStatement.executeUpdate();
        System.out.println("ROWS DELETED: "+rowsDeleted);

        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM PRODUCTS_HARIKA");
        while (resultSet.next()){
            System.out.print(resultSet.getInt(1)+ " ");
            System.out.print(resultSet.getString(2)+" ");
            System.out.println(resultSet.getInt(3));

        }
    }
}
