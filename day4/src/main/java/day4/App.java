package day4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;



public class App 
{   
    static String[] rawData;

    public static class Card
    {
        int[] winningNumbers;
        int[] usersNumbers;
    }
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        readDataFile("path_to_your_file.txt");
        for(String line : rawData) {
            System.out.println(line);
        }
    }

    public static void readDataFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rawData = lines.toArray(new String[0]);
    }

    public Card splitScoreCard(String aScoreCard) {
        Card card = new Card();


        return card;
    }
}