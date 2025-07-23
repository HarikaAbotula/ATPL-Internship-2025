import java.time.*;
public class DayOfWeek {
    public static void main(String[] args) {
       LocalDate date = LocalDate.of(2025,12,25);
       //int day = date.getDayOfWeek().getValue(); 
       String dayName = date.getDayOfWeek().name();

       System.out.println("Day Of the week: "+ dayName);
    }
}
