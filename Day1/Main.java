import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class Main{
    List<String> parsedData = new ArrayList<String>();
    List<String> withoutWordyNumbers = new ArrayList<String>();
    List<String> characterlessData = new ArrayList<String>();
    List<String> removedSingles = new ArrayList<String>();
    List<String> removedLongerNumbers = new ArrayList<String>();
    private int sum;

    public static void main(String[] args) {
        Main main = new Main();
        main.readDataFromFile();
        main.parseWordedNumbers();
        main.removeLetters();
        main.removeSingleCharacters();
        main.removeDoubleCharacters();
        main.calculateTotal();
        System.out.println(main.sum);
            


    }
    
    public void readDataFromFile() {
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

    public void parseWordedNumbers(){
        for (int i = 0 ; i < parsedData.size(); i++){
            String newString = parsedData.get(i);
            newString = newString.replaceAll("one", "1");
            newString = newString.replaceAll("two", "2");
            newString = newString.replaceAll("three", "3");
            newString = newString.replaceAll("four", "4");
            newString = newString.replaceAll("five", "5");
            newString = newString.replaceAll("six", "6");
            newString = newString.replaceAll("seven", "7");
            newString = newString.replaceAll("eight", "8");
            newString = newString.replaceAll("nine", "9");
            withoutWordyNumbers.add(newString);
        }
    }

    public void removeLetters(){
        for (String singleCoordinate : withoutWordyNumbers) {
            characterlessData.add(singleCoordinate.replaceAll("[a-zA-Z]+", ""));
        }
    }

    public void removeSingleCharacters() {
        for (String string : characterlessData) {
            if(string.length() == 1) {
                removedSingles.add(string + string);
            } else {
                removedSingles.add(string);
            }
        }
    }

        public void removeDoubleCharacters() {
        for (String string : removedSingles) {
            if(string.length() > 2 ) {
                char firstChar = string.charAt(0);
                char lastChar = string.charAt(string.length() -1);
                String shortenedString = Character.toString(firstChar) + Character.toString(lastChar);
                removedLongerNumbers.add(shortenedString);
            } else {
                removedLongerNumbers.add(string);
            }
        }
    }

    public void calculateTotal() {
        for (String doubleCharString : removedLongerNumbers) {
            sum += Integer.parseInt(doubleCharString);
        }
    }

}