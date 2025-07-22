import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
            Connection con= DriverManager.getConnection("jdbc:mysql://192.168.71.15:3306/intern","intern2025","intern2025");
            System.out.println("Connection established");
            con.close();

    }
}
