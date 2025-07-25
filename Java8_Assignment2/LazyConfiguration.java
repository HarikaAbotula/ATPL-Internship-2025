import java.util.Optional;
import java.util.function.Supplier;

public class LazyConfiguration {
    public static void main(String[] args) {
        String javaPath = System.getenv("Java_Home");

        Optional<String> javaPathOptional = Optional.ofNullable(javaPath);

        Supplier<String> loadDefaultJavaPath = () ->{
            System.out.println("Java Path not set.Loading the default java path...");
            return "C:Program Files/Java/jdk1.8";
        };

        String finalJavaPath = javaPathOptional.orElseGet(loadDefaultJavaPath);
        System.out.println("Final Java Path: "+finalJavaPath);
    }
}
