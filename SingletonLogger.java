/*
2. Write a Java Program to implement Singleton pattern to create the singleton class
LoggerService with a private constructor and a public static method to get the
instance.
*/

// Singleton Pattern - LoggerService
// Author: Pratik

class LoggerService
{
    // Single instance of LoggerService
    private static LoggerService instance;

    // Private constructor
    private LoggerService()
    {
        System.out.println("LoggerService object created");
    }

    // Public static method to get the instance
    public static LoggerService getInstance()
    {
        if(instance == null)
        {
            instance = new LoggerService();
        }

        return instance;
    }

    // Logger method
    public void log(String message)
    {
        System.out.println("LOG: " + message);
    }
}

// Main class
public class SingletonLogger
{
    public static void main(String[] args)
    {
        LoggerService logger1 = LoggerService.getInstance();
        logger1.log("Application Started");

        LoggerService logger2 = LoggerService.getInstance();
        logger2.log("User Logged In");

        // Checking whether both references point to same object
        if(logger1 == logger2)
        {
            System.out.println("Both are the same LoggerService object");
        }
    }
}