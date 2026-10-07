/*
1. Write a Java Program to implement I/ODecorator for converting uppercase
letters to lowercase letters.
*/

// I/O Decorator Pattern
// Convert Uppercase Letters to Lowercase
// Author: Pratik

import java.io.*;

class LowerCaseInputStream extends FilterInputStream
{
    public LowerCaseInputStream(InputStream in)
    {
        super(in);
    }

    public int read() throws IOException
    {
        int c = super.read();

        if(c == -1)
        {
            return -1;
        }

        return Character.toLowerCase((char)c);
    }
}

public class IODecorator
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInput =
            new FileInputStream("input.txt");

        LowerCaseInputStream lowerCaseInput =
            new LowerCaseInputStream(fileInput);

        int c;

        while((c = lowerCaseInput.read()) != -1)
        {
            System.out.print((char)c);
        }

        lowerCaseInput.close();
    }
}