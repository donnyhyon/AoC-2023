package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class AppTest 
{
    public boolean compareHashMap(HashMap<String, int[]> map1, HashMap<String, int[]> map2) {
        Boolean answer = false;
        answer = (map1.size() == map2.size());
        answer = (map1.keySet() == map2.keySet());
        answer = (map1.values() == map2.values());
        return answer;
    }

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

    @Test
    public void getTheIndiciesOfTheNumberInTheLineItCameFrom(){
        App game = new App();
        List<String> input = Arrays.asList("467","114");
        String[] file = game.readDataFile("data2.txt");
        String line1 = file[0];
        HashMap<String, int[]> actual = game.getIndicies(input, line1);

        Collection<int[]> hashvalues = actual.values();
        System.out.println(Arrays.deepToString(hashvalues));
        HashMap<String, int[]> expected = new HashMap<>();
        expected.put("467",new int[]{0,1,2});
        expected.put("144", new int[]{5,6,7});
        // assertTrue(compareHashMap(actual, expected));
    }

    
    // parse data table into x and y co-ords
    // iterate through each line. find numbers within that line.

    //  for each number, get the first and last index of that number == grid
    //  expand grid out by 1 square in every direction...
    // create a search function to check for any unique characters within a given grid


}
