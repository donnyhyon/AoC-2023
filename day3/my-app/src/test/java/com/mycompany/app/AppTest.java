package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
        GameData gameData = game.readDataFile("data2.txt");
        assertEquals(gameData.lines[0], "467..114..");
        assertEquals(gameData.lines[3], "......#...");
    }

    @Test
    public void findNumbersWithinALine(){
        App game = new App();
        GameData gameData = game.readDataFile("data2.txt");
        String line1 = gameData.lines[0];
        List<String> actual = game.findNumbersInALine(line1);
        List<String> expected = Arrays.asList("467","114");
        assertEquals(actual,  expected);
    }

    @Test
    public void getTheIndiciesOfTheNumberInTheLineItCameFrom(){
        App game = new App();
        List<String> input = Arrays.asList("467","114");
        GameData gameData = game.readDataFile("data2.txt");
        String line1 = gameData.lines[0];
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
        List<Integer>  actual = game.expandGrid(input);
        List<Integer>  expected = new ArrayList<>();
        expected.add(4);
        expected.add(8);      
        assertEquals(expected, actual);
    }

    @Test
    public void get1DIndexAndExpandInto3DIndexWhenAtAnEdge(){
        App game = new App();
        int[] input = new int[]{0,1,2};
        List<Integer>  actual = game.expandGrid(input);
        List<Integer>  expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);      
        assertEquals(expected, actual);
    }

    @Test
    public void get_1D_Index_And_Expand_Into_3D_Index_When_At_The_Other_Edge(){
        App game = new App();
        int[] input = new int[]{9,10};
        List<Integer>  actual = game.expandGrid(input);
        List<Integer>  expected = new ArrayList<>();
        expected.add(8);
        expected.add(10);      
        assertEquals(expected, actual);
    }

    @Test
    public void find_Special_Characters(){
        App game = new App();
        String lineInput = "0123456&89";
        List<Integer> desiredIndexRange = new ArrayList<>();
        desiredIndexRange.add(8);
        desiredIndexRange.add(9);
        Boolean actual = game.checkForSpecialCharacters(lineInput, desiredIndexRange);
        Boolean expected = false;
        assertEquals(expected, actual);

    }

    @Test
    public void find_Special_Characters_true(){
        App game = new App();
        String lineInput = "012345678&";
        List<Integer> desiredIndexRange = new ArrayList<>();
        desiredIndexRange.add(8);
        desiredIndexRange.add(9);
        Boolean actual = game.checkForSpecialCharacters(lineInput, desiredIndexRange);
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void find_special_characters_in_2D_array(){
        App game = new App();
        String[] lineInputs = new String[]{"£$23456789","01%$456789", "01234*&789"};
        List<Integer> desiredIndexRange = new ArrayList<>();
        desiredIndexRange.add(8);
        desiredIndexRange.add(9);
        Boolean actual = game.process3dGrid(lineInputs, desiredIndexRange);
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void find_special_characters_in_2D_array_true(){
        App game = new App();
        String[] lineInputs = new String[]{"£$23456789","01%$456789", "01234*&%$@"};
        List<Integer> desiredIndexRange = new ArrayList<>();
        desiredIndexRange.add(8);
        desiredIndexRange.add(9);
        Boolean actual = game.process3dGrid(lineInputs, desiredIndexRange);
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void find_special_characters_in_2D_array_true_real(){
        App game = new App();
        String[] lineInputs = new String[]{"467..114..", "467..114..", "...*......"};
        List<Integer> desiredIndexRange = new ArrayList<>();
        desiredIndexRange.add(0);
        desiredIndexRange.add(4);
        Boolean actual = game.process3dGrid(lineInputs, desiredIndexRange);
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void return_part_numbers(){
        App game = new App();
        game.readDataFile("data2.txt");
        List<String> actual = game.getPartNumbers();
        List<String> expected = new ArrayList<>();
        expected.add("467");
        expected.add("35");
        expected.add("633");
        expected.add("617");
        expected.add("592");
        expected.add("755");
        expected.add("664");
        expected.add("598");
        assertEquals(expected, actual);
    }

    @Test
    public void return_game_answer(){
        App game = new App();
        game.readDataFile("data2.txt");
        List<String> partNumbers = game.getPartNumbers();
        int actual = game.getAnswer(partNumbers);
        int expected = 4361;
        assertEquals(expected, actual);
    }

    
    // parse data table into x and y co-ords
    // iterate through each line. find numbers within that line.
    //  for each number, get the first and last index of that number == grid
    //  expand grid out by 1 square in every direction...

    // create a search function to check for any unique characters within a given grid


}
