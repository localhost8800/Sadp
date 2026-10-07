/*
2. Write a java program to implement Proxy Pattern which efficiently manages the loading
and displaying of images by introducing a proxy that controls access to the real image
object.
*/

    // Proxy Pattern - Image Loading
// Author: Pratik

// Subject
interface Image
{
    void display();
}

// Real Subject
class RealImage implements Image
{
    private String fileName;

    public RealImage(String fileName)
    {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk()
    {
        System.out.println("Loading image: " + fileName);
    }

    public void display()
    {
        System.out.println("Displaying image: " + fileName);
    }
}

// Proxy
class ProxyImage implements Image
{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName)
    {
        this.fileName = fileName;
    }

    public void display()
    {
        if(realImage == null)
        {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}

// Main Class
public class Ex-ProxyDemo
{
    public static void main(String[] args)
    {
        Image image = new ProxyImage("photo.jpg");

        System.out.println("First display:");
        image.display();

        System.out.println();

        System.out.println("Second display:");
        image.display();
    }
}