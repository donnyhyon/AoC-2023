package day4;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;



public class App 
{   
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public String[] readDataFile(String filePath) {
        int count = 0;

        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                count++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] rawData = new String[count];

        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            int eachline = 0;
            while ((line = bufferedReader.readLine()) != null) {
                    rawData[eachline] = line;
                    eachline++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawData;
    }
    
    public String removeVerbose(String aString){
        return aString.replaceFirst("^.*?:", "").trim();
    }

    public int[][] splitScoreCard(String aScoreCard) {
        String[] splitStrings = removeVerbose(aScoreCard).split("\\|");
        String[] strWinningNumbers =  removeVerbose(splitStrings[0]).split("\\s+");
        String[] strUserNumbers =  splitStrings[1].trim().split("\\s+");
        
        int[] intWinningNumbers = new int[strWinningNumbers.length];
        int[] intUserNumbers = new int[strUserNumbers.length];
        for (int i = 0; i < strWinningNumbers.length; i ++){
            intWinningNumbers[i] = Integer.parseInt(strWinningNumbers[i].trim());
        }
        for (int i = 0; i < strUserNumbers.length; i ++){
            intUserNumbers[i] = Integer.parseInt(strUserNumbers[i].trim());
        }
        Arrays.sort(intWinningNumbers);
        Arrays.sort(intUserNumbers);
        int[][] scoreCard = new int[][]{intWinningNumbers,intUserNumbers};
    
        return scoreCard;
    }

    public int convertMatchesToPoints(int matches) {
        if (matches == 0){
            return 0;
        } 
        return (int) Math.pow(2,(matches-1));
        
    }

}