/*
2. Write a Java Program to implement Singleton pattern for multithreading.
*/

class Singleton
{
    private static Singleton instance;

    private Singleton()
    {
        System.out.println("Singleton Object Created");
    }

    public static synchronized Singleton getInstance()
    {
        if(instance == null)
        {
            instance = new Singleton();
        }

        return instance;
    }

    void display()
    {
        System.out.println("Object HashCode: " + this.hashCode());
    }
}

// Thread class
class MyThread extends Thread
{
    public void run()
    {
        Singleton obj = Singleton.getInstance();

        System.out.println(
            Thread.currentThread().getName() +
            " got Singleton object"
        );

        obj.display();
    }
}

// Main class
public class SingletonMultithreading
{
    public static void main(String[] args)
    {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}