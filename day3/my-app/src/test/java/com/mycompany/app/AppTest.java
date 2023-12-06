package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldParseFile()
    {
        App game = new App();
        List<String> file = game.readDataFile("data2.txt");
        // System.out.println(file);
    }

    
    // parse data table into x and y co-ords
    // iterate through each line. find numbers within that line.
    //  for each number, get the first and last index of that number == grid
    //  expand grid out by 1 square in every direction...
    // create a search function to check for any unique characters within a given grid


}
