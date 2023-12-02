import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class Main{
    static List<String> parsedData = new ArrayList<String>();
    static List<String> characterlessData = new ArrayList<String>();

    public static void main(String[] args) {
        reader();
        alphabetRemover();
        System.out.println(characterlessData);



    }     
    
    public static void reader() {
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
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


}