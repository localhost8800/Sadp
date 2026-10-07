/*
3. Write a Java Program to implement Bridge design pattern to produce and assemble the
two different vehicles.
*/

// Bridge Design Pattern - Vehicles
// Author: Pratik

// Implementor
interface Workshop
{
    void produce();
    void assemble();
}

// Concrete Implementor 1
class ProduceWorkshop implements Workshop
{
    public void produce()
    {
        System.out.println("Producing vehicle");
    }

    public void assemble()
    {
        System.out.println("Assembling vehicle");
    }
}

// Abstraction
abstract class Vehicle
{
    protected Workshop workshop;

    protected Vehicle(Workshop workshop)
    {
        this.workshop = workshop;
    }

    abstract void manufacture();
}

// Refined Abstraction 1
class Car extends Vehicle
{
    public Car(Workshop workshop)
    {
        super(workshop);
    }

    void manufacture()
    {
        System.out.println("Car:");
        workshop.produce();
        workshop.assemble();
    }
}

// Refined Abstraction 2
class Bike extends Vehicle
{
    public Bike(Workshop workshop)
    {
        super(workshop);
    }

    void manufacture()
    {
        System.out.println("Bike:");
        workshop.produce();
        workshop.assemble();
    }
}

// Main Class
public class BridgeDemo
{
    public static void main(String[] args)
    {
        Workshop workshop = new ProduceWorkshop();

        Vehicle car = new Car(workshop);
        car.manufacture();

        System.out.println();

        Vehicle bike = new Bike(workshop);
        bike.manufacture();
    }
}