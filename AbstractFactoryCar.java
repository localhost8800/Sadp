/*
1. Write a Java Program to implement Abstract factory pattern to create cars and
specifications specific to North America, Europe.
*/

// Abstract Factory Pattern - Cars and Specifications
// Author: Pratik

// Abstract Product 1
interface Car
{
    void showCar();
}

// Abstract Product 2
interface Specification
{
    void showSpecification();
}

// North America Car
class NorthAmericaCar implements Car
{
    public void showCar()
    {
        System.out.println("North America Car: Ford Mustang");
    }
}

// North America Specification
class NorthAmericaSpecification implements Specification
{
    public void showSpecification()
    {
        System.out.println("Specification: Left Hand Drive, Miles");
    }
}

// Europe Car
class EuropeCar implements Car
{
    public void showCar()
    {
        System.out.println("Europe Car: BMW");
    }
}

// Europe Specification
class EuropeSpecification implements Specification
{
    public void showSpecification()
    {
        System.out.println("Specification: Right Hand Drive, Kilometers");
    }
}

// Abstract Factory
interface CarFactory
{
    Car createCar();
    Specification createSpecification();
}

// North America Factory
class NorthAmericaFactory implements CarFactory
{
    public Car createCar()
    {
        return new NorthAmericaCar();
    }

    public Specification createSpecification()
    {
        return new NorthAmericaSpecification();
    }
}

// Europe Factory
class EuropeFactory implements CarFactory
{
    public Car createCar()
    {
        return new EuropeCar();
    }

    public Specification createSpecification()
    {
        return new EuropeSpecification();
    }
}

// Main Class
public class AbstractFactoryCar
{
    public static void main(String[] args)
    {
        System.out.println("North America:");

        CarFactory northAmericaFactory = new NorthAmericaFactory();

        Car car1 = northAmericaFactory.createCar();
        car1.showCar();

        Specification spec1 =
            northAmericaFactory.createSpecification();

        spec1.showSpecification();

        System.out.println();

        System.out.println("Europe:");

        CarFactory europeFactory = new EuropeFactory();

        Car car2 = europeFactory.createCar();
        car2.showCar();

        Specification spec2 =
            europeFactory.createSpecification();

        spec2.showSpecification();
    }
}