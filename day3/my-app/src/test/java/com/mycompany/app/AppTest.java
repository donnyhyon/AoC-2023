package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldParseFile()
    {
        App game = new App();
        String[] file = game.readDataFile("data2.txt");
        assertEquals(file[0], "467..114..");
        assertEquals(file[3], "......#...");
    }

    @Test
    public void findNumbersWithinALine(){
        App game = new App();
        String[] file = game.readDataFile("data2.txt");
        String line1 = file[0];
        List<String> actual = game.findNumbersInALine(line1);
        List<String> expected = Arrays.asList("467","114");
        assertEquals(actual,  expected);
    }

    
    // parse data table into x and y co-ords

    // iterate through each line. find numbers within that line.
    //  for each number, get the first and last index of that number == grid
    //  expand grid out by 1 square in every direction...
    // create a search function to check for any unique characters within a given grid


}
