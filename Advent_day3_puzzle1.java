//COMPLETE
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Advent_day3_puzzle1 {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("day3.txt"))) {
            String line;
            StringBuilder contentBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line); //puts all data onto a single line for processing purposes
            }
            String fileContent = contentBuilder.toString();
            searchInput(fileContent, numbers);

        }catch (IOException e) {
        e.printStackTrace();
        }

    }

    static void searchInput(String line, List<String> numbers) {
        String phrase = line;
        Pattern pattern = Pattern.compile("mul\\(\\d+\\,\\d+\\)"); //establishes criteria to search for
        Matcher matcher = pattern.matcher(phrase); //does the searching
        int total = 0;

    
        while (matcher.find()) {
            String cleanedUp = matcher.group().replaceAll("mul()[^0-9]", "").replaceAll("\\)", "");
            String[] splitMe = cleanedUp.split(",",2); //create an array using the paired numbers, splitting at the comma
            for (int i = 0; i < 1; i++){ //iterate once over the newly created array
                String zeroIndex = splitMe[0];
                // System.out.println(zeroIndex);
                String firstIndex = splitMe[1];
                // System.out.println(firstIndex);
                total += (Integer.parseInt(zeroIndex) * (Integer.parseInt(firstIndex)));
                System.out.println("Current total: " + total);
            }
        }
    }
}
