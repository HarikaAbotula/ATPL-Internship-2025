import java.util.Scanner;
public class CustomExceptionLoginFailed {
    public static void login(String uName,String password) throws LoginFailedException{
        if(!uName.matches("^[a-zA-Z][a-zA-Z0-9_]{4,9}$") || !password.matches("^[A-Z][a-z0-9@#$%^&*!]{7,}$")){
            throw new LoginFailedException("Invalid credentials,please provide valid details");
        }
        System.out.println("lOGIN Succesfully done!!");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String uName=sc.nextLine();
        String password=sc.nextLine();
        try{
            login(uName,password);
        }
        catch(LoginFailedException lfe){
            System.out.println("Exception occured: "+lfe.getMessage());
        }
        sc.close();
    }
}
class LoginFailedException extends Exception{
    LoginFailedException (String msg){
        super(msg);
    }
}
