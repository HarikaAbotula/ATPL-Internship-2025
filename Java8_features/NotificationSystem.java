import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Customer {
    String name;
    boolean subscribed;

    Customer(String name, boolean subscribed) {
        this.name = name;
        this.subscribed = subscribed;
    }

    public String toString() {
        return name + " (" + (subscribed ? "Subscribed" : "Not Subscribed") + ")";
    }
}


public class NotificationSystem {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Harika", true));
        customers.add(new Customer("Kitty", false));
        customers.add(new Customer("Himaja", true));
        customers.add(new Customer("Roshie", false));

        Consumer<Customer> sendNotify = customer -> System.out.println("Sending notification to: " + customer.name);

        customers.stream()
                .filter(c -> c.subscribed)
                .forEach(sendNotify);
    }
}
