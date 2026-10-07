/*
1. Write a java program to implement Adapter pattern to design Heart Model to Beat
Model.
*/

// Adapter Pattern - Heart Model to Beat Model
// Author: Pratik

// Target Interface
interface BeatModel
{
    void initialize();
    void on();
    void off();
    void setBPM(int bpm);
    int getBPM();
}

// Adaptee
class HeartModel
{
    private int heartRate = 72;

    public void start()
    {
        System.out.println("Heart Model Started");
    }

    public void stop()
    {
        System.out.println("Heart Model Stopped");
    }

    public int getHeartRate()
    {
        return heartRate;
    }
}

// Adapter
class HeartAdapter implements BeatModel
{
    private HeartModel heart;

    public HeartAdapter(HeartModel heart)
    {
        this.heart = heart;
    }

    public void initialize()
    {
        System.out.println("Initializing Heart Model");
    }

    public void on()
    {
        heart.start();
    }

    public void off()
    {
        heart.stop();
    }

    public void setBPM(int bpm)
    {
        System.out.println("Heart Model does not support setting BPM.");
    }

    public int getBPM()
    {
        return heart.getHeartRate();
    }
}

// Main Class
public class AdapterHeartBeat
{
    public static void main(String[] args)
    {
        HeartModel heart = new HeartModel();

        BeatModel beat = new HeartAdapter(heart);

        beat.initialize();
        beat.on();

        System.out.println("Heart Rate: " + beat.getBPM() + " BPM");

        beat.setBPM(80);

        beat.off();
    }
}