/*
3. Write a Java Program to implement Abstract factory pattern for various
functionalities of the mobile phone, such as taking a photo, recording a video.
 */

// Abstract Product 1
interface Camera
{
    void takePhoto();
}

// Abstract Product 2
interface VideoCamera
{
    void recordVideo();
}

// Concrete Product - Android
class AndroidCamera implements Camera
{
    public void takePhoto()
    {
        System.out.println("Android: Taking Photo");
    }
}

class AndroidVideoCamera implements VideoCamera
{
    public void recordVideo()
    {
        System.out.println("Android: Recording Video");
    }
}

// Concrete Product - iPhone
class IPhoneCamera implements Camera
{
    public void takePhoto()
    {
        System.out.println("iPhone: Taking Photo");
    }
}

class IPhoneVideoCamera implements VideoCamera
{
    public void recordVideo()
    {
        System.out.println("iPhone: Recording Video");
    }
}

// Abstract Factory
interface MobileFactory
{
    Camera createCamera();
    VideoCamera createVideoCamera();
}

// Concrete Factory - Android
class AndroidFactory implements MobileFactory
{
    public Camera createCamera()
    {
        return new AndroidCamera();
    }

    public VideoCamera createVideoCamera()
    {
        return new AndroidVideoCamera();
    }
}

// Concrete Factory - iPhone
class IPhoneFactory implements MobileFactory
{
    public Camera createCamera()
    {
        return new IPhoneCamera();
    }

    public VideoCamera createVideoCamera()
    {
        return new IPhoneVideoCamera();
    }
}

// Main Class
public class Mobile
{
    public static void main(String[] args)
    {
        System.out.println("Android Mobile:");

        MobileFactory androidFactory = new AndroidFactory();

        Camera androidCamera = androidFactory.createCamera();
        androidCamera.takePhoto();

        VideoCamera androidVideo = androidFactory.createVideoCamera();
        androidVideo.recordVideo();

        System.out.println();

        System.out.println("iPhone Mobile:");

        MobileFactory iPhoneFactory = new IPhoneFactory();

        Camera iPhoneCamera = iPhoneFactory.createCamera();
        iPhoneCamera.takePhoto();

        VideoCamera iPhoneVideo = iPhoneFactory.createVideoCamera();
        iPhoneVideo.recordVideo();
    }
}