//Create a static nested class Logger inside a SystemUtils class. Use it to log actions in the main method.
class SystemUtils {
    public static class Logger {
        public static void log(String message) {
            System.out.println("Log: " + message);
        }
    }
}

public class StaticNestedClass {
    public static void main(String[] args) {
        SystemUtils.Logger.log("Application started");
        System.out.println("work in progrsss");
        SystemUtils.Logger.log("Application finished");
    }
}

     

