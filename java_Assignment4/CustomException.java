import java.io.*;
import java.util.Scanner;
public class CustomException{
        public static void checkDet(String uName) throws LoginFailedException{
             if(uName==null || uName.isEmpty()){
                 throw new LoginFailedException("Invalid Login Details");
            }
            System.out.println("Username is valid,login successfully");
        }
    public static void main(String args[]) {
        Scanner sc =new Scanner(System.in);
        String uName=sc.nextLine();
        String password=sc.nextLine();
        try{
            checkDet(uName);
        }
        catch(LoginFailedException lfe){
            System.out.println("Exception: "+lfe.getMessage());
        }
    }

}

class LoginFailedException extends Exception{
    LoginFailedException (String msg){
        super(msg);
    }
}