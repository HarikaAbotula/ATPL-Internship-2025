import java.io.*;
import java.util.*;
import java.text.MessageFormat;
public class MessageFormatting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       for(int i=1;i<=3;i++){
                System.out.println("Enter student"+i+"details: ");
                System.out.println("Enter Student name");
                String name = scanner.next();

                System.out.println("Enter Student Department");
                String department=scanner.next();

                System.out.println("Enter Student GPA");
                double gpa=scanner.nextDouble();
                String messageFormatting = MessageFormat.format("Student {0} from {1} department has secured a GPA of {2}." ,name,department,gpa);
                System.out.println(messageFormatting);
       }
       scanner.close();
    }
}
