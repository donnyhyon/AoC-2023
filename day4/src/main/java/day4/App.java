package day4;

import java.util.ArrayList;
import java.util.List;


public class App 
{   
    static String[] rawData;
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        readDataFile("path_to_your_file.txt");
        for(String line : rawData) {
            System.out.println(line);
        }
    }

    public static void readDataFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rawData = lines.toArray(new String[0]);
    }
}