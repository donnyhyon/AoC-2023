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
        String[] rGBData = new String[2];
        int redIndex = unOrderedRGB.indexOf(".*red.*");
        int greenIndex = unOrderedRGB.indexOf(".*green.*");
        int blueIndex = unOrderedRGB.indexOf(".*blue.*");
        rGBData[0] = (redIndex != -1)? unOrderedRGB[redIndex] : "0 red";
        rGBData[1] = (greenIndex != -1)? unOrderedRGB[greenIndex] : "0 green";
        rGBData[2] = (blueIndex != -1)? unOrderedRGB[blueIndex] : "0 blue";

        return rGBData;

    }
    
}
