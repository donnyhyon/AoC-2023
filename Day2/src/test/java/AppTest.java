import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class AppTest 
{
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
}
