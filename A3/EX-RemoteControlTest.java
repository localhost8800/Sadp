/*
2. Write a Java Program to implement command pattern to test Remote Control.
*/

// Command Interface
interface Command
{
    void execute();
    void undo();
}

// Light Receiver
class Light
{
    String location;

    Light(String location)
    {
        this.location = location;
    }

    void on()
    {
        System.out.println(location + " Light is ON");
    }

    void off()
    {
        System.out.println(location + " Light is OFF");
    }
}

// Light ON Command
class LightOnCommand implements Command
{
    Light light;

    LightOnCommand(Light light)
    {
        this.light = light;
    }

    public void execute()
    {
        light.on();
    }

    public void undo()
    {
        light.off();
    }
}

// Light OFF Command
class LightOffCommand implements Command
{
    Light light;

    LightOffCommand(Light light)
    {
        this.light = light;
    }

    public void execute()
    {
        light.off();
    }

    public void undo()
    {
        light.on();
    }
}

// Fan Receiver
class CeilingFan
{
    String location;

    CeilingFan(String location)
    {
        this.location = location;
    }

    void on()
    {
        System.out.println(location + " Ceiling Fan is ON");
    }

    void off()
    {
        System.out.println(location + " Ceiling Fan is OFF");
    }
}

// Fan ON Command
class CeilingFanOnCommand implements Command
{
    CeilingFan fan;

    CeilingFanOnCommand(CeilingFan fan)
    {
        this.fan = fan;
    }

    public void execute()
    {
        fan.on();
    }

    public void undo()
    {
        fan.off();
    }
}

// Fan OFF Command
class CeilingFanOffCommand implements Command
{
    CeilingFan fan;

    CeilingFanOffCommand(CeilingFan fan)
    {
        this.fan = fan;
    }

    public void execute()
    {
        fan.off();
    }

    public void undo()
    {
        fan.on();
    }
}

// Remote Control - Invoker
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
public class EXRemoteControlTest
{
    public static void main(String[] args)
    {
        Light light = new Light("Living Room");
        CeilingFan fan = new CeilingFan("Living Room");

        RemoteControl remote = new RemoteControl();

        Command lightOn =
                new LightOnCommand(light);

        Command lightOff =
                new LightOffCommand(light);

        Command fanOn =
                new CeilingFanOnCommand(fan);

        Command fanOff =
                new CeilingFanOffCommand(fan);

        System.out.println("Light ON:");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\nLight OFF:");
        remote.setCommand(lightOff);
        remote.pressButton();

        System.out.println("\nUndo:");
        remote.pressUndo();

        System.out.println("\nFan ON:");
        remote.setCommand(fanOn);
        remote.pressButton();

        System.out.println("\nFan OFF:");
        remote.setCommand(fanOff);
        remote.pressButton();

        System.out.println("\nUndo:");
        remote.pressUndo();
    }
}