
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class UserSearchEmail {
    public static void main(String[] args) {
        List<User> users = List.of(
            new User("Harika", "harika@mail.com"),
            new User("Arjun", null),
            new User("Meera", "meera@company.com")
        );

        String targetName = "Meera";  

        
        Function<String, String> toUpperCase = String::toUpperCase;

        Optional<User> matchedUser = users.stream()
                                          .filter(u -> u.name.equalsIgnoreCase(targetName))
                                          .findFirst();

       
        matchedUser
            .flatMap(User::getEmailOptional)    
            .map(toUpperCase)                   
            .ifPresentOrElse(
                email -> System.out.println("Email: " + email),
                () -> System.out.println("Email not available")
            );
    }
}
