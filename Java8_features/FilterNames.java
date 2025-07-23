import java.util.Arrays;
import java.util.List;

public class FilterNames {
    public static void main(String[] args) {
    
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Tom", "Angela", "Steve");

        names.stream()
            .filter(name -> name.startsWith("A"))
            .forEach(name -> System.out.print(name + " "));
    }
}

    
