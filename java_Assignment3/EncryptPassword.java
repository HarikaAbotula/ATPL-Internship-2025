//Ask user for a password. Create a method that "encrypts" the password. 
//Show that using immutable strings ensures the original password doesn't change after encryption. 

import java.util.Scanner;

public class EncryptPassword {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String password=sc.nextLine();
        System.out.println("Original Password: "+password);
        String encryptPassword = encryptedPassword(password);
        System.out.println("Encrypted Password: " + encryptPassword);
        System.out.println("Original Password after encryption: " + password);
        sc.close();
    }
    public static String encryptedPassword(String password){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<password.length();i++){
            char c= password.charAt(i);
            sb.append((char) (c+3));
        }
        return sb.toString();
    }

}

