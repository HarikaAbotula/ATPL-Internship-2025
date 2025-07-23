import java.sql.*;

public class InsertWithNullHandling {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/interndb";
        String user = "root";
        String password = "database@01";

        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO items (name, description) VALUES (?, ?)");
        ) {
            preparedStatement.setString(1, "Notebook");
            // Optional field - insert NULL
            preparedStatement.setNull(2, Types.VARCHAR);

            int result = preparedStatement.executeUpdate();
            System.out.println("Row inserted: " + result);

            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM ITEMS");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

