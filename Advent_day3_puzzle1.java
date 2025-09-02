
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
                contentBuilder.append(line);
            }
            String fileContent = contentBuilder.toString();
            searchInput(fileContent, numbers);
    } catch (IOException e) {
        e.printStackTrace();
    }

    }

    static void searchInput(String line, List<String> numbers) {
        String phrase = line;
        Pattern pattern = Pattern.compile("mul\\(\\d+\\,\\d+\\)");
        Matcher matcher = pattern.matcher(phrase);

    

        while (matcher.find()){
            System.out.println(matcher.group());
            String cleanedUp = matcher.group().replaceAll("mul()[^0-9]", "").replaceAll("\\)", "");
            numbers.add(cleanedUp);
            System.out.println(numbers);
        }
    }


}
