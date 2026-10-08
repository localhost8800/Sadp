/*
2. Write a Java Program to implement an undo command to test Ceiling fan.
 */

// Receiver
class CeilingFan
{
    String location;
    int speed;

    static final int OFF = 0;
    static final int LOW = 1;
    static final int MEDIUM = 2;
    static final int HIGH = 3;

    CeilingFan(String location)
    {
        this.location = location;
        speed = OFF;
    }

    void high()
    {
        speed = HIGH;
        System.out.println(location + " Ceiling Fan is HIGH");
    }

    void medium()
    {
        speed = MEDIUM;
        System.out.println(location + " Ceiling Fan is MEDIUM");
    }

    void low()
    {
        speed = LOW;
        System.out.println(location + " Ceiling Fan is LOW");
    }

    void off()
    {
        speed = OFF;
        System.out.println(location + " Ceiling Fan is OFF");
    }

    int getSpeed()
    {
        return speed;
    }
}

// Command Interface
interface Command
{
    void execute();
    void undo();
}

// Concrete Command
class CeilingFanHighCommand implements Command
{
    CeilingFan ceilingFan;
    int previousSpeed;

    CeilingFanHighCommand(CeilingFan ceilingFan)
    {
        this.ceilingFan = ceilingFan;
    }

    public void execute()
    {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    public void undo()
    {
        if(previousSpeed == CeilingFan.HIGH)
            ceilingFan.high();
        else if(previousSpeed == CeilingFan.MEDIUM)
            ceilingFan.medium();
        else if(previousSpeed == CeilingFan.LOW)
            ceilingFan.low();
        else
            ceilingFan.off();
    }
}

// Invoker
class RemoteControl
{
    Command command;

    void setCommand(Command command)
    {
        this.command = command;
    }

    void pressButton()
    {
        command.execute();
    }

    void pressUndo()
    {
        command.undo();
    }
}

// Main Class
public class 2CeilingFanTest
{
    public static void main(String[] args)
    {
        CeilingFan ceilingFan =
                new CeilingFan("Living Room");

        RemoteControl remote = new RemoteControl();

        Command highCommand =
                new CeilingFanHighCommand(ceilingFan);

        remote.setCommand(highCommand);

        System.out.println("Press High:");
        remote.pressButton();

        System.out.println("Press Undo:");
        remote.pressUndo();
    }
}