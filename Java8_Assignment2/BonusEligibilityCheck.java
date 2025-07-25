import java.util.*;
import java.util.function.*;

class Employee {
    String name;
    double salary;
    String email;

    Employee(String name, double salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
    }
    // Method to get email as an Optional
     public Optional<String> getEmailOptional() {
        return Optional.ofNullable(email);
    }
}


public class BonusEligibilityCheck {
     public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000, "john@gmail.com"));
        employees.add(new Employee("Lessy", 66000, null));
        employees.add(new Employee("Mike", 70000, "mike@gmail.com"));
        employees.add(new Employee("Harika", 80000, ""));

        Predicate<Employee> eligible = emp -> emp.salary > 60000;

        employees.stream()
                .filter(eligible)
                 .forEach(emp -> {
                     String email = emp.getEmailOptional()
                                       .filter(e -> !e.isEmpty())
                                       .orElse("Email not available");

                     System.out.println(emp.name + " : " + email);
                 });
    }  

}
