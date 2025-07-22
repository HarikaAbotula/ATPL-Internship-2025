import java.sql.*;
import java.util.Scanner;

public class ReusePreparedStatement {
    public static void main(String args[]){
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/interndb", "root", "database@01");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCTS_HARIKA VALUES(?,?,?,?)");
        ){
            Scanner scanner= new Scanner(System.in);
            while(true){
                System.out.println("Enter Product ID: ");
                int productID = scanner.nextInt();

                System.out.println("Enter Product name:");
                scanner.nextLine();
                String productName = scanner.nextLine();

                System.out.println("Enter product price: ");
                int price = scanner.nextInt();

                System.out.println("Enter Warranty date: ");
                scanner.nextLine();
                String warrantyDate = scanner.nextLine();

                preparedStatement.setInt(1,productID);
                preparedStatement.setString(2,productName);
                preparedStatement.setInt(3,price);
                preparedStatement.setDate(4, Date.valueOf(warrantyDate));
                preparedStatement.executeUpdate();
                System.out.println("Record inserted");

                System.out.println("Do you want ot insert another record?,Type [yes/no]:");
                String choice = scanner.next();
                if(choice.equalsIgnoreCase("no")){
                    break;
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery("Select * from products_harika");
            while(resultSet.next()){
                System.out.print(resultSet.getInt(1)+ " ");
                System.out.print(resultSet.getString(2)+" ");
                System.out.print(resultSet.getInt(3)+" ");
                System.out.println(resultSet.getString(4));
            }
            scanner.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
