/*
2. Write a Java Program to implement Adapter pattern for Enumeration iterator.
 */

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

// Adapter
class EnumerationIterator implements Iterator<String>
{
    private Enumeration<String> enumeration;

    public EnumerationIterator(Enumeration<String> enumeration)
    {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext()
    {
        return enumeration.hasMoreElements();
    }

    @Override
    public String next()
    {
        return enumeration.nextElement();
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}

// Main class
public class Enumerationiterator
{
    public static void main(String[] args)
    {
        Vector<String> vector = new Vector<String>();

        vector.add("Java");
        vector.add("Python");
        vector.add("C++");
        vector.add("JavaScript");

        Enumeration<String> enumeration = vector.elements();

        Iterator<String> iterator =
            new EnumerationIterator(enumeration);

        System.out.println("Elements using Iterator:");

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}