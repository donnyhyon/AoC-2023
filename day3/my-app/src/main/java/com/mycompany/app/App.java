package com.mycompany.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;

public class App 
{
    public static class GameData{
        public static int lineCount;
        public static String[] lines;

        public static int getLineCount(){
            return lineCount;
        }
    }


    public static void main(String[] args )
    {
        System.out.println( "Hello day3" );
    }

    public GameData readDataFile(String filepath){
        GameData gameData = new GameData();
        gameData.lineCount = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            while (reader.readLine() != null) {
                gameData.lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameData.lines = new String[gameData.lineCount];
        int onLine = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = reader.readLine()) != null) {
                gameData.lines[onLine] = line;
                onLine ++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameData;
    }

    public List<String> findNumbersInALine(String aLine) {
        List<String> numbersInALine = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(aLine);
        while(matcher.find()){
            numbersInALine.add(matcher.group());
        }
        return numbersInALine;
    }

    public HashMap<String, int[]> getIndicies(List<String> numbersInALine, String theLine) {
        HashMap<String, int[]> numberToIndicies = new HashMap<>();
        for (String aNumber : numbersInALine) {
            int lengthOfNumber = aNumber.length();
            int startingIndexOfNumber = theLine.indexOf(aNumber);
            int[] numberIndicies = new int[lengthOfNumber];
            for(int i = 0 ; i < lengthOfNumber ; i ++ ) {
                if(i == 0){
                    numberIndicies[i] = startingIndexOfNumber;
                } else {
                    numberIndicies[i] = startingIndexOfNumber + i ;
                }

            }

            numberToIndicies.put(aNumber, numberIndicies);
        }
        return numberToIndicies;
    }

    public List<Integer> expandGrid(int[] oneDArray) {
        int lengthOfLine = GameData.getLineCount();
        List<Integer> expandedArray = new ArrayList<Integer>();
        for (int i = 0; i <  oneDArray.length; i++ ) {
            if (i == 0){
                int numberToAdd = oneDArray[0] == 0 ?  oneDArray[i] : oneDArray[i] - 1;
                expandedArray.add(numberToAdd);
            } else if ( i == oneDArray.length -1){
                int numberToAdd = oneDArray[oneDArray.length -1] == lengthOfLine ?  oneDArray[i] : oneDArray[i] + 1;
                expandedArray.add(numberToAdd);
            } else {
                continue;
            }
        }
        return expandedArray;
    }

    public Boolean checkForSpecialCharacters(String lineInput, List<Integer> desiredIndexRange) {
        String subSetOfStringToCheck = lineInput.substring(desiredIndexRange.get(0), desiredIndexRange.get(desiredIndexRange.size() -1));

        Pattern pattern = Pattern.compile("[&/*@=\\-%+]");
        Matcher matcher = pattern.matcher(subSetOfStringToCheck);
        return matcher.find();
    }


}

