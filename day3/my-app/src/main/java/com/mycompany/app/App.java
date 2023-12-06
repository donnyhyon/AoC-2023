package com.mycompany.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;

public class App 
{
    public static void main( )
    {
        System.out.println( "Hello day3" );
    }

    public String[] readDataFile(String filepath){
        int lineCount = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            while (reader.readLine() != null) {
                lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] parsedLines = new String[lineCount];
        int onLine = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = reader.readLine()) != null) {
                parsedLines[onLine] = line;
                onLine ++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedLines;
    }

    public List<String> findNumbersInALine(String aLine) {
        List<String> numbersInALine = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(aLine);
        while(matcher.find()){
            numbersInALine.add(matcher.group());
        }
        return numbersInALine;
    }



}

