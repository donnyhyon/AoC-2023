import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;

public class AppTest 
{
    final boolean areHashesEqual(HashMap<Integer, int[][]> map1, HashMap<Integer, int[][]> map2) {
    if (map1.size() != map2.size()) {
        return false;
    }

    for (Integer key : map1.keySet()) {
        if (!map2.containsKey(key) || !Arrays.deepEquals(map1.get(key), map2.get(key))) {
            return false;
        }
    }
    return true;
    }

    @Test
    public void shouldSplitAtColon()
    {
        String input = "Game 1: 7 blue, 6 green, 3 red; 3 red, 5 green, 1 blue; 1 red, 5 green, 8 blue; 3 red, 1 green, 5 blue";
        
        App game = new App();
        String[] result = game.colonSplit(input);
        String[] expectedArray = {"Game 1", "7 blue, 6 green, 3 red; 3 red, 5 green, 1 blue; 1 red, 5 green, 8 blue; 3 red, 1 green, 5 blue"};
        assertEquals(result, expectedArray);
    }

    @Test
    public void shouldSplitAtSemiColon(){
        String input = "7 blue, 6 green, 3 red; 3 red, 5 green, 1 blue; 1 red, 5 green, 8 blue; 3 red, 1 green, 5 blue";
        App game = new App();
        String[] result = game.semiColonSplit(input);
        String[] expectedResult = {"7 blue, 6 green, 3 red", "3 red, 5 green, 1 blue","1 red, 5 green, 8 blue","3 red, 1 green, 5 blue"};
        assertEquals(result, expectedResult);
    }

    @Test
    public void shouldSplitAtComma(){
        String input = "7 blue, 6 green, 3 red";
        App game = new App();
        String[] result = game.commaSplit(input);
        String[] expectedResult = {"7 blue", "6 green", "3 red"};

        assertEquals(result, expectedResult);
    } 

    @Test
    public void shouldReorderToRGBForConsistency(){
        String[] input = {"7 blue", "6 green", "3 red"};
        App game = new App();
        String[] result = game.orderToRGB(input);
        String[] expectedResult = {"3 red", "6 green", "7 blue"};

        assertEquals(result, expectedResult);
    }

    @Test
    public void shouldAutoFillZeroForMissingColours(){
        App game = new App();
        String[] input = {"7 blue", "6 green"};
        String[] result = game.orderToRGB(input);
        String[] expectedResult = {"0 red", "6 green", "7 blue"};
        assertEquals(result, expectedResult);
    }

    @Test
    public void shouldConvertStringArrayIntoIntArray() {
        App game = new App();
        String[] input = {"7 blue", "6 green", "3 red"};
        int[] result = game.convertToIntArray(input);
        int[] expectedResult = { 7, 6, 3 };
        assertEquals(Arrays.toString(result), Arrays.toString(expectedResult));
    }

    @Test
    public void removeGame(){
        App game = new App();
        String input = "Game 1";
        String result = game.removeGame(input);
        String expectedResult = "1";

        assertEquals(result, expectedResult);
    }

    @Test
    public void convertToInt(){
        App game = new App();
        String input = "1";
        int result = game.convertToInt(input);
        int expectedResult = 1;
        assertEquals(result, expectedResult);
    }

    @Test
    public void processGameIdData(){
        App game = new App();
        String input = "Game 1";
        int result = game.processGameID(input);
        int expectedResult = 1;
        assertEquals(result, expectedResult);
    }

    @Test
    public void processGameResultData(){
        App game = new App();
        String input = "7 blue, 6 green, 3 red; 3 red, 5 green, 1 blue; 1 red, 5 green, 8 blue; 3 red, 1 green, 5 blue";
        int[][] result = game.processGameData(input);
        int[][] expectedResult = {{3,6,7},{3,5,1},{1,5,8},{3,1,5}};
        assertEquals(Arrays.deepToString(result), Arrays.deepToString(expectedResult));
    }

    @Test
    public void wrapGameIntInArrayArray(){
        App game = new App();
        int input = 1;
        int[][] actual = game.intDoubleWrap(input);
        int[][] expected = {{1}};
        assertEquals(Arrays.deepToString(actual), Arrays.deepToString(expected));
    }

    @Test
    public void processRawDataLine(){
        App game = new App();
        String input = "Game 1: 7 blue, 6 green, 3 red; 3 red, 5 green, 1 blue; 1 red, 5 green, 8 blue; 3 red, 1 green, 5 blue";
        HashMap<Integer, int[][]> gameResults = new HashMap<>();
        HashMap<Integer, int[][]> actual = game.processAGame(input);
        HashMap<Integer, int[][]> expected = new HashMap<>();
        expected.put(1, new int[][]{{3,6,7},{3,5,1},{1,5,8},{3,1,5}});
        // assertEquals(actual, expected);  
        assertTrue(areHashesEqual(actual, expected));
    }
}
