package day4;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;



public class App 
{   
    public ArrayList<String> rawData = new ArrayList<>();
    static int count = 0;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int readDataFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                rawData.add(line);
                count++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public String removeVerbose(String aString){
        return aString.replaceFirst("^.*?:", "").trim();
    }

    public int[][] splitScoreCard(String aScoreCard) {
        String[] splitStrings = aScoreCard.split("|");
        String[] strWinningNumbers =  removeVerbose(splitStrings[0]).split(" ");
        String[] strUserNumbers =  splitStrings[1].trim().split(" ");
        int[] intWinningNumbers = new int[strWinningNumbers.length];
        int[] intUserNumbers = new int[strUserNumbers.length];
        for (int i = 0; i < strWinningNumbers.length; i ++){
            intWinningNumbers[i] = Integer.parseInt(strWinningNumbers[i]);
        }
        for (int i = 0; i < strUserNumbers.length; i ++){
            intUserNumbers[i] = Integer.parseInt(strUserNumbers[i]);
        }
        Arrays.sort(intWinningNumbers);
        System.out.println(Arrays.toString(intWinningNumbers));
        System.out.println(Arrays.toString(intUserNumbers));
        Arrays.sort(intUserNumbers);
        int[][] scoreCard = new int[][]{intWinningNumbers,intUserNumbers};
    
        return scoreCard;
    }
}