import javax.naming.StringRefAddr;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App 
{
    public HashMap<Integer, int[]> parsedData = new HashMap<>();
    public HashMap<Integer, Boolean> viableGames = new HashMap<>();



    public static void main( String[] args )
    {
        System.out.println( "Day2 AoC Challenge" );
        // App app = new App();
        // app.readDataFile("data2.txt");
    }

    public String[] colonSplit(String gameData){
        String[] colonSplitData = new String[2];
        colonSplitData = gameData.split(": ");
        return colonSplitData;
    }

    public String[] semiColonSplit(String gameData){
        String[] semiColonSplitData = new String[2];
        semiColonSplitData = gameData.split("; ");
        return semiColonSplitData;
    }

    public String[] commaSplit(String gameData){
        String[] commaSplitData = new String[2];
        commaSplitData = gameData.split(", ");
        return commaSplitData;
    }

    public String[] orderToRGB(String[] unOrderedRGB){
        String[] rGBData = new String[3];

        int redIndex = -1, greenIndex = -1, blueIndex = -1;
        for (int i = 0; i < unOrderedRGB.length; i++) {
            if (unOrderedRGB[i].contains("red")){
                redIndex = i;
            } else if (unOrderedRGB[i].contains("green")){
                greenIndex = i;
            } else if (unOrderedRGB[i].contains("blue")){
                blueIndex = i;
            }
        }
        rGBData[0] = (redIndex != -1)? unOrderedRGB[redIndex] : "0 red";
        rGBData[1] = (greenIndex != -1)? unOrderedRGB[greenIndex] : "0 green";
        rGBData[2] = (blueIndex != -1)? unOrderedRGB[blueIndex] : "0 blue";
        return rGBData;
    }
    public int[] convertToIntArray(String[] stringArray){
        int[] intArray = new int[stringArray.length];
        for (int i = 0 ; i <  stringArray.length; i++){
            stringArray[i] = stringArray[i].replaceAll(" red", "");
            stringArray[i] = stringArray[i].replaceAll(" green", "");
            stringArray[i] = stringArray[i].replaceAll(" blue", "");
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    public String removeGame(String gameID){
        String id = gameID.replaceAll("Game ", "");
        return id;
    }

    public int convertToInt(String id){
        return Integer.parseInt(id);
    }

    public int processGameID(String gameID){
        String withoutGame = removeGame(gameID);
        int asInt = convertToInt(withoutGame);
        return asInt;
    }

    public int[] processGameData(String gameData){
        int[] gameTotal = new int[3];
        String[] splitGames = semiColonSplit(gameData);
        int[][] processedGameData = new int[splitGames.length][3];
        for (int i = 0 ; i < splitGames.length ; i++) {
            String oneGame = splitGames[i];
            String[] splitGame = commaSplit(oneGame);
            String[] orderedSplitGame = orderToRGB(splitGame);
            processedGameData[i] = convertToIntArray(orderedSplitGame);
        }
        gameTotal = totalDice(processedGameData);
        return gameTotal;
    }

    public HashMap<Integer, int[]> processAGame(String gameData){
        HashMap<Integer,int[]> parsedGameData = new HashMap<>();
        String[] splitAtColon = colonSplit(gameData);
        parsedGameData.put((processGameID(splitAtColon[0])), (processGameData(splitAtColon[1])));
        return parsedGameData;
    }

    public void readDataFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                
                parsedData.putAll(processAGame(line));
            }
            bufferedReader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] totalDice(int[][] gameDice){
        int[] totals = new int[]{0,0,0};

        for (int[]set : gameDice) {
            for (int i = 0 ; i < set.length ; i ++){
                if(totals[i] < set[i]){
                    totals[i] = set[i];
                }
            }
        }
        return totals;
    }

    public HashMap<Integer,Boolean> checkViableGames(int[] inputDice){
        HashMap<Integer, Boolean> viableGames = new HashMap<>();
        for (Map.Entry<Integer, int[]> entry : parsedData.entrySet()) {
            Integer key = entry.getKey();
            int[] value = entry.getValue();
            for(int i = 0 ; i < inputDice.length; i++){
                int expectedDice = inputDice[i];
                int actualDice = value[i];
                if (actualDice > expectedDice){
                    viableGames.put(key, false);
                    break;
                } else {
                    viableGames.put(key, true);
                }
            }

        }
        return viableGames;
    }

        public int getAllMaxDiceNeeded(){
        HashMap<Integer, Integer> maxDicePerGamePowered = new HashMap<>();
        for (Map.Entry<Integer, int[]> entry : parsedData.entrySet()) {
            int[] maxDiceRequiredPerGame = new int[]{0,0,0};
            Integer key = entry.getKey();
            int[] value = entry.getValue();
            for(int i = 0 ; i < 3 ; i++) {
                if (value[i] > maxDiceRequiredPerGame[i]) {
                    maxDiceRequiredPerGame[i] = value[i];
                }
            int powered = maxDiceRequiredPerGame[0] * maxDiceRequiredPerGame[1] * maxDiceRequiredPerGame[2];
            maxDicePerGamePowered.put(key, powered);
            }
        }
        int finalGameTotal = 0;
        for (Map.Entry<Integer, Integer> entry: maxDicePerGamePowered.entrySet()){
            Integer value = entry.getValue();
            finalGameTotal += value;
        }
        System.out.println(finalGameTotal);
        return finalGameTotal;
    }



    public int getAnswer(HashMap<Integer,Boolean> viableGames){
        int answer = 0;
        for (Map.Entry<Integer, Boolean> entry : viableGames.entrySet()){
            Integer key = entry.getKey();
            Boolean value = entry.getValue();
            if (value == true) {
                answer += key;
            }
            else {
                continue;
            }
        }
        System.out.println(answer);
        return answer;
    }
}   
