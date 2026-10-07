/*
1. Write a Java Program to implement Factory method for Pizza Store with
createPizza(), orderPizza(), prepare(), Bake(), cut(), box(). Use this to create a
variety of pizza’s like NyStyleCheesePizza, ChicagoStyleCheesePizza etc.

*/
// Factory Method Design Pattern - Pizza Store


abstract class Pizza
{
    String name;

    void prepare()
    {
        System.out.println("Preparing " + name);
    }

    void bake()
    {
        System.out.println("Baking " + name);
    }

    void cut()
    {
        System.out.println("Cutting " + name);
    }

    void box()
    {
        System.out.println("Boxing " + name);
    }
}

// New York Style Cheese Pizza
class NYStyleCheesePizza extends Pizza
{
    NYStyleCheesePizza()
    {
        name = "New York Style Cheese Pizza";
    }
}

// Chicago Style Cheese Pizza
class ChicagoStyleCheesePizza extends Pizza
{
    ChicagoStyleCheesePizza()
    {
        name = "Chicago Style Cheese Pizza";
    }
}

// Pizza Store
abstract class PizzaStore
{
    abstract Pizza createPizza(String type);

    Pizza orderPizza(String type)
    {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

// New York Pizza Store
class NYPizzaStore extends PizzaStore
{
    Pizza createPizza(String type)
    {
        if(type.equalsIgnoreCase("cheese"))
        {
            return new NYStyleCheesePizza();
        }

        return null;
    }
}

// Chicago Pizza Store
class ChicagoPizzaStore extends PizzaStore
{
    Pizza createPizza(String type)
    {
        if(type.equalsIgnoreCase("cheese"))
        {
            return new ChicagoStyleCheesePizza();
        }

        return null;
    }
}

// Main class
public class FactoryMethodPizza
{
    public static void main(String args[])
    {
        PizzaStore nyStore = new NYPizzaStore();

        System.out.println("Ordering New York Style Cheese Pizza");
        Pizza pizza1 = nyStore.orderPizza("cheese");

        System.out.println();

        PizzaStore chicagoStore = new ChicagoPizzaStore();

        System.out.println("Ordering Chicago Style Cheese Pizza");
        Pizza pizza2 = chicagoStore.orderPizza("cheese");
    }
}

