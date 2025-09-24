package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Advent_day5_puzzle1 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> rules = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\harrison.knight\\VS Code Projects\\resources\\day5example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] ruleArray = line.split("\\|");
                int[] ruleIntArray = new int[ruleArray.length];
                for (int i = 0; i < ruleArray.length; i++) {
                    ruleIntArray[i] = Integer.parseInt(ruleArray[i]);
                    if rules.containsKey(ruleIntArray[0])
                    rules.put(ruleIntArray[0], ruleIntArray[1]);
                }
                
                rules.put(ruleIntArray[0], ruleIntArray[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
