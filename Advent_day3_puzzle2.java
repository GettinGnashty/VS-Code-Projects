import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Advent_day3_puzzle2 {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\harrison.knight\\VS Code Projects\\resources\\day3example.txt"))) {
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
//this SHOULD work, but not finished yet
    // static void splitData(String line, List<String> numbers) {
    //     String[] dontRemoved = line.split("don\\'t\\(\\)");
    //     for (int i = 0; i < dontRemoved.length; i++){
    //         initialMul.add(dontRemoved[0]); //adding the intial mul before the first do/don't
    //         String[] doMul = line.split("do\\(\\)");
    //         System.out.println(dontRemoved[i]);
    //     }
    //     searchInput()

    // }

    
    static void searchInput(String line, List<String> numbers) {
        
        List<String> firstMulInstructions = new ArrayList<>();
        String phrase = line;
        String[] dontRemoved = line.split("don\\'t\\(\\)");
        firstMulInstructions.add(dontRemoved[0]); //adds everything before the first "don't()" mul statement
        String[] doRemoved = phrase.split("do\\(\\)");
        System.out.println(firstMulInstructions); //the initial mul instructions upto the first don't
        for (int i = 0; i < dontRemoved.length; i++){
            System.out.println(doRemoved[i]);
        }
        // Pattern pattern = Pattern.compile("mul\\(\\d+\\,\\d+\\)"); //establishes criteria to search for
        // Matcher matcher = pattern.matcher(phrase); //does the searching
        // int total = 0;

    
        // while (matcher.find()) {
        //     String cleanedUp = matcher.group().replaceAll("mul()[^0-9]", "").replaceAll("\\)", "");
        //     String[] splitMe = cleanedUp.split(",",2); //create an array using the paired numbers, splitting at the comma
        //     for (int i = 0; i < 1; i++){ //iterate once over the newly created array
        //         String zeroIndex = splitMe[0];
        //         // System.out.println(zeroIndex);
        //         String firstIndex = splitMe[1];
        //         // System.out.println(firstIndex);
        //         total += (Integer.parseInt(zeroIndex) * (Integer.parseInt(firstIndex)));
        //         System.out.println("Current total: " + total);
        //     }
        // }
    }
}
