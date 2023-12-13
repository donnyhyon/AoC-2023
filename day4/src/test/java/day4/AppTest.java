package day4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void remove_verbose(){
        String input = "Card 1: 41 48 83 86 17";
        App game = new App();
        String actual = game.removeVerbose(input);
        String expected = "41 48 83 86 17";
        assertEquals(expected, actual);
    }

    @Test
    public void check_splitting_array_into_two_sets()
    {
        App game = new App();
        String[] rawData = game.readDataFile("data2.txt");
        String input  = rawData[0];
        int[][] actual = game.splitScoreCard(input);
        int[][] expected = new int[][]{{17,41,48,83,86},{6,9,17,31,48,53,83,86}};
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual));
    }

    @Test
    public void check_splitting_array_into_two_sets_2()
    {
        App game = new App();
        String[] rawData = game.readDataFile("data2.txt");
        String input  = rawData[1];
        int[][] actual = game.splitScoreCard(input);
        int[][] expected = new int[][]{{13, 16, 20, 32, 61},{17, 19, 24, 30, 32, 61, 68, 82}};
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual));
    }

    @Test
    public void determines_number_of_points_based_on_matching_numbers(){
        App game = new App();
        int matches = 3;
        int actual = game.convertMatchesToPoints(matches);
        int expected = 4;
        assertEquals(expected,actual);
    }

        @Test
        public void determines_0_points_for_no_matches(){
        App game = new App();
        int matches = 0;
        int actual = game.convertMatchesToPoints(matches);
        int expected = 0;
        assertEquals(expected,actual);
    }
}
