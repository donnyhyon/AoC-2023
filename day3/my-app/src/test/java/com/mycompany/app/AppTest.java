package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mycompany.app.App.GameData;

public class AppTest 
{

    public boolean areHashesEqual(HashMap<String, int[]> map1, HashMap<String, int[]> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (String key : map1.keySet()) {
            if (!map2.containsKey(key) || !Arrays.equals(map1.get(key), map2.get(key))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void shouldParseFile()
    {
        App game = new App();
        GameData result = game.readDataFile("data2.txt");
        assertEquals(result.lines[0], "467..114..");
        assertEquals(result.lines[3], "......#...");
    }

    @Test
    public void findNumbersWithinALine(){
        App game = new App();
        GameData result = game.readDataFile("data2.txt");
        String line1 = result.lines[0];
        List<String> actual = game.findNumbersInALine(line1);
        List<String> expected = Arrays.asList("467","114");
        assertEquals(actual,  expected);
    }

    @Test
    public void getTheIndiciesOfTheNumberInTheLineItCameFrom(){
        App game = new App();
        List<String> input = Arrays.asList("467","114");
        GameData result = game.readDataFile("data2.txt");
        String line1 = result.lines[0];
        HashMap<String, int[]> actual = game.getIndicies(input, line1);

        HashMap<String, int[]> expected = new HashMap<>();
        expected.put("467",new int[]{0,1,2});
        expected.put("114", new int[]{5,6,7});
        assertTrue(areHashesEqual(actual, expected));
    }

    @Test
    public void get1DIndexAndExpandInto3DIndex(){
        App game = new App();
        int[] input = new int[]{5,6,7};
        int[] actual = game.expandGrid(input);
        int[] expected = new int[]{4,5,6,7};
        assertEquals(Arrays.toString(actual),Arrays.toString(expected));

    }

    
    // parse data table into x and y co-ords
    // iterate through each line. find numbers within that line.

    //  for each number, get the first and last index of that number == grid
    //  expand grid out by 1 square in every direction...
    // create a search function to check for any unique characters within a given grid


}
