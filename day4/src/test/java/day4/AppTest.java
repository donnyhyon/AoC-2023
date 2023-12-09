package day4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import day4.App.Card;

public class AppTest 
{
    @BeforeEach
    public void setUp(){
        App game = new App();
    }

    @Test
    public void splits_input_into_two_arrays()
    {
        String input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = game.splitScoreCard(input);
        String[] winningNumbers = card.winningNumbers;
        String[] usersNumbers = card.usersNumbers;
        assertEquals(new String[]{41, 48, 83, 86, 17}, winningNumbers);
        asserEquals(new String[]{83, 86,  6, 31, 17,  9, 48, 53}, usersNumbers);
    }

    
}
