/*
3. Write a Java Program to implement Iterator Pattern for Designing Menu like Breakfast,
Lunch or Dinner Menu.
*/

import java.util.ArrayList;

// Menu Item
class MenuItem
{
    String name;
    double price;

    MenuItem(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String toString()
    {
        return name + " - Rs." + price;
    }
}

// Iterator Interface
interface Iterator
{
    boolean hasNext();
    MenuItem next();
}

// Concrete Iterator
class MenuIterator implements Iterator
{
    ArrayList<MenuItem> items;
    int position = 0;

    MenuIterator(ArrayList<MenuItem> items)
    {
        this.items = items;
    }

    public boolean hasNext()
    {
        return position < items.size();
    }

    public MenuItem next()
    {
        MenuItem item = items.get(position);
        position++;
        return item;
    }
}

// Menu
class Menu
{
    ArrayList<MenuItem> items = new ArrayList<MenuItem>();

    void addItem(String name, double price)
    {
        items.add(new MenuItem(name, price));
    }

    Iterator createIterator()
    {
        return new MenuIterator(items);
    }
}

// Waitress
class Waitress
{
    Menu breakfastMenu;
    Menu lunchMenu;
    Menu dinnerMenu;

    Waitress(Menu breakfastMenu, Menu lunchMenu, Menu dinnerMenu)
    {
        this.breakfastMenu = breakfastMenu;
        this.lunchMenu = lunchMenu;
        this.dinnerMenu = dinnerMenu;
    }

    void printMenu()
    {
        System.out.println("===== BREAKFAST MENU =====");
        printMenu(breakfastMenu.createIterator());

        System.out.println("\n===== LUNCH MENU =====");
        printMenu(lunchMenu.createIterator());

        System.out.println("\n===== DINNER MENU =====");
        printMenu(dinnerMenu.createIterator());
    }

    void printMenu(Iterator iterator)
    {
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}

// Main Class
public class 3MenuIteratorDemo
{
    public static void main(String[] args)
    {
        Menu breakfastMenu = new Menu();
        breakfastMenu.addItem("Idli", 40);
        breakfastMenu.addItem("Poha", 30);
        breakfastMenu.addItem("Upma", 35);

        Menu lunchMenu = new Menu();
        lunchMenu.addItem("Veg Thali", 120);
        lunchMenu.addItem("Paneer Rice", 100);
        lunchMenu.addItem("Dal Tadka", 90);

        Menu dinnerMenu = new Menu();
        dinnerMenu.addItem("Roti", 20);
        dinnerMenu.addItem("Paneer Masala", 130);
        dinnerMenu.addItem("Fried Rice", 100);

        Waitress waitress =
                new Waitress(breakfastMenu, lunchMenu, dinnerMenu);

        waitress.printMenu();
    }
}