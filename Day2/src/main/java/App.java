public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public String[] colonSplit(String gameData){
        String[] splitData = new String[2];
        splitData = gameData.split(": ");
        return splitData;
    }

    public String[] semiColonSplit(String gameData){
        return null;
    }
    
}
