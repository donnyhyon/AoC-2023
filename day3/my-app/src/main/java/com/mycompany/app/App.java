package com.mycompany.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class App 
{
    public static void main( )
    {
        System.out.println( "Hello day3" );
    }

    public List<String> readDataFile(String filepath){
        List<String> parsedLines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = reader.readLine()) != null) {

                parsedLines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedLines;
    }
}

