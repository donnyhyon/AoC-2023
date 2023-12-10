package day4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Set;



import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import day4.App.Card;

public class AppTest 
{

    @Test
    public void check_splitting_array_into_two_sets()
    {
        App game = new App();
        String input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = new Card();
        game.readDataFile("data2.txt");
        card = game.splitScoreCard(input);
        int[] winningNumbers = card.winningNumbers;
        int[] usersNumbers = card.usersNumbers;
        assertEquals(new int[]{17,41,48,83,86}, winningNumbers);
        assertEquals(new int[]{6,9,17,31,48,53,83,86}, usersNumbers);
    }

    
}
