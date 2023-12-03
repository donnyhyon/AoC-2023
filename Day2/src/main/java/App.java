import javax.naming.StringRefAddr;
import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Day2 AoC Challenge" );
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

    public int[][] processGameData(String gameResultData){
        String[] splitGames = semiColonSplit(gameResultData);

        int[][] processedGameData = new int[splitGames.length][3];
        for (int i = 0 ; i < splitGames.length ; i++ ) {
            String oneGame = splitGames[i];
            String[] splitGame = commaSplit(oneGame);
            String[] orderedSplitGame = orderToRGB(splitGame);
            processedGameData[i] = convertToIntArray(orderedSplitGame);
        }
        return processedGameData;
    }

}   
