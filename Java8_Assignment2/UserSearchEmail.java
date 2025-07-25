
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class User{
    String name;
    String email;

    User(String name,String email){
        this.name = name;
        this.email = email;
    }

    public Optional<String> getEmailOptional() {
        return Optional.ofNullable(email);
    }
}
public class UserSearchEmail {
    public static void main(String[] args) {
        ArrayList<User> usersList = new ArrayList<>();
            usersList.add(new User("Harika","harika@gmail.com"));
            usersList.add(new User("Kitty", null));
            usersList.add(new User("Roshie","rioshini@company.com"));
            usersList.add(new User("Himaja","himaja@outlook.com"));

        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the target name:");
        String targetName = scanner.nextLine();  

        Function<String, String> toUpperCase = String::toUpperCase;

          // 1. Find the user by name using Stream and filter
        Optional<User> foundUser = usersList.stream()
                .filter(user -> user.name.equalsIgnoreCase(targetName))
                .findFirst();

        String result = foundUser.flatMap(User::getEmailOptional) 
                .map(toUpperCase)
                .orElse("Email not Found");
                
        System.out.println(result);
        scanner.close();     

    }
}
