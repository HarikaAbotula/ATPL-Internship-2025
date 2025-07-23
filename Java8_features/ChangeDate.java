import java.time.LocalDate;

public class ChangeDate {
     public static void main(String[] args) {
        LocalDate today = LocalDate.now(); // Fixed today for demo

        LocalDate plus10Days = today.plusDays(10);
        LocalDate minus2Months = today.minusMonths(2);

        System.out.println("Original Date: " + today);
        System.out.println("After adding 10 days: " + plus10Days);
        System.out.println("After subtracting 2 months: " + minus2Months);
    }
}
