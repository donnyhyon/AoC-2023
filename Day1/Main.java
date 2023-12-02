import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class Main{
    static List<String> parsedData = new ArrayList<String>();
    static List<String> characterlessData = new ArrayList<String>();
    static List<String> removedSingles = new ArrayList<String>();
    static List<String> removedLongerNumbers = new ArrayList<String>();

    public static void main(String[] args) {
        reader();
        alphabetRemover();
        singleHandler();
        doubleHandler();
        System.out.println(removedLongerNumbers);



    }     
    
    public static void reader() {
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              parsedData.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public static void alphabetRemover(){
        for (String singleCoordinate : parsedData) {
            characterlessData.add(singleCoordinate.replaceAll("[a-zA-Z]+", ""));
        }
    }

    public static void singleHandler() {
        for (String string : characterlessData) {
            if(string.length() == 1) {
                removedSingles.add(string + string);
            } else {
                removedSingles.add(string);
            }
        }
    }

        public static void doubleHandler() {
        for (String string : removedSingles) {
            if(string.length() > 2 ) {
                char firstChar = string.charAt(0);
                char lastChar = string.charAt(string.length() -1);
                String shortenedSrtring = Character.toString(firstChar) + Character.toString(lastChar);
                removedLongerNumbers.add(shortenedSrtring);
            } else {
                removedLongerNumbers.add(string);
            }
        }
    }


}