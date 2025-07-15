import java.text.MessageFormat;

public class MessageFormatting {
    public static void main(String[] args) {
        
        String[] names = {"John", "Nancy", "Steve"};
        String[] departments = {"CSE", "ECE", "IT"};
        double[] gpas = {8.5, 9.2, 7.8};

        String template = "Student {0} from {1} department has secured a GPA of {2}.";

        for (int i = 0; i < names.length; i++) {
            String message = MessageFormat.format(template, names[i], departments[i], gpas[i]);
            System.out.println(message);
        }
    }
}
