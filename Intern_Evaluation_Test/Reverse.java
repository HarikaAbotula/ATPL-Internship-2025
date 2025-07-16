import java.util.*;
public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String string = scanner.nextLine();
        String reversedString="";
        for(int index=string.length()-1;index>0;index--){
            reversedString += string.charAt(index);
        }
        System.out.println(reversedString);
        scanner.close();
    }
}

