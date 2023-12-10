package day4;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import static org.junit.Assert.assertEquals;


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
        card = game.splitScoreCard(input);
        Set<Integer> winningNumbers = card.winningNumbers;
        Set<Integer> usersNumbers = card.usersNumbers;

    }

    
}
