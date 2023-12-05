package com.mycompany.app;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello day3" );
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data2.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

