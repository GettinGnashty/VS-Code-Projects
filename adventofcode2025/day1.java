package adventofcode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class day1 {

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\harrison.knight\\VS Code Projects\\adventofcode2025\\day1example.txt"))) {
            String line;
                while ((line = reader.readLine()) != null) {
                    numbers.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        findTheZeros(numbers);

    }
    static int findTheZeros(List<String> numbers) {
        int startingNumber = 50;

        //creating the hashmap for referencing positive if L or negative if R
        HashMap<Character, Integer> plusOrMinus = new HashMap<>();
        plusOrMinus.put('L', 1);
        plusOrMinus.put('R', -1);


        create1thru99(); //create an array of numbers 1 thru 99
        for (int i = 0; i < numbers.size(); i++) {
            char leftOrRight = numbers.get(i).charAt(0);
            int positiveOrNegative = plusOrMinus.get(leftOrRight); //converts the corresponding direction to + or -
            StringBuilder sb = new StringBuilder(numbers.get(i));
            String justTheNumber = sb.deleteCharAt(0);


        }
        return 5; //placeholder value
    } 

    static int[] create1thru99() { //creates an array of numbers 1 through 99
        int[] range = IntStream.rangeClosed(1,99).toArray();
        return range;
    }

    



}
