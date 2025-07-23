import java.time.*;
public class CalculatePersonAge {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1995,05,15);
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);
        System.out.println("Age is: "+age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days");
    }
}