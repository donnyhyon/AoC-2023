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
    static ArrayList<String> rawData = new ArrayList<>();

    public static class Card
    {
        int[] winningNumbers;
        int[] usersNumbers;
    }
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public void readDataFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                rawData.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String removeVerbose(String aString){
        return aString.replaceFirst("^.*?:", "").trim();
    }

    public Card splitScoreCard(String aScoreCard) {
        Card card = new Card();





        return card;
    }
}