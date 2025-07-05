public class SystemUtils {
    static class Logger {
        void log(String message) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        SystemUtils.Logger logger = new SystemUtils.Logger();

        logger.log("Application started");
        String username = "Harika";
        logger.log("User '" + username + "' attempting to log in...");
        logger.log("Login successful");
        String[] actions = {
            "Loading dashboard...",
            "Dashboard loaded successfully",
            "Logout",
        };

        for (int i = 0; i < actions.length; i++) {
            logger.log("Step " + (i + 1) + ": " + actions[i]);
        }

        logger.log("Application ended");
    }
}

