import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Advent_day3_puzzle2 {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("day3.txt"))) {
            String line;
            StringBuilder contentBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line); //puts all info read in onto a single line for processing purposes
            }
            String fileContent = contentBuilder.toString();
            searchInput(fileContent, numbers);

    } catch (IOException e) {
        e.printStackTrace();
    }

    }

    

    static void searchInput(String line, List<String> numbers) {
        boolean toDo = true;
        String allData = line;
        Pattern doTrue = Pattern.compile("");
        Pattern dontFalse = Pattern.compile("don\\'t\\(\\)");
        Pattern findMul = Pattern.compile("do\\(\\)[.*]mul\\(\\d+\\,\\d+\\)"); //establishes criteria to search for
        Matcher mulMatcher = findMul.matcher(allData); //searches for mul
        Matcher doMatcher = doTrue.matcher(allData); //searches for do()
        Matcher dontMatcher = dontFalse.matcher(allData);// searches for don't()
        int total = 0;


            if (doMatcher.find()){
                toDo = true;
            }
            if(dontMatcher.find()) {
                toDo=false;
            }
            if (toDo){
                mulMatcher.find();
                String cleanedUp = mulMatcher.group().replaceAll("mul()[^0-9]", "").replaceAll("\\)", "");
                String[] splitMe = cleanedUp.split(",",2); //create an array using the paired numbers, splitting at the comma
                for (int i = 0; i < 1; i++){ //iterate once over the newly created array
                    String zeroIndex = splitMe[0];
                    System.out.println(zeroIndex);
                    String firstIndex = splitMe[1];
                    System.out.println(firstIndex);
                    total += (Integer.parseInt(zeroIndex) * (Integer.parseInt(firstIndex)));
                    System.out.println("Current total: " + total);
                }
            }
        
    }

    static void searchDont(String line, Matcher dontMatcher) {
        while (dontMatcher.find()) {}
    }
}
