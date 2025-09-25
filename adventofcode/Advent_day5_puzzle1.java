package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Advent_day5_puzzle1 {

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> rules = new HashMap<>();
        List<List<Integer>> pages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\harrison.knight\\VS Code Projects\\resources\\day5example.txt"))) {
            String line;
            // Pattern.pattern = Pattern.compile("\\d{1,2}\\|\\d{1,2}");
            // Matcher matcher = pattern.matcher(line);

            while ((line = reader.readLine()) != null) {
                
                String[] ruleArray = line.split("\\|");
                int[] ruleIntArray = new int[ruleArray.length];
                    ruleIntArray[0] = Integer.parseInt(ruleArray[0]);
                    ruleIntArray[1] = Integer.parseInt(ruleArray[1]);
                    if (rules.containsKey(ruleIntArray[0])) {
                        rules.get(ruleIntArray[0]).add(ruleIntArray[1]);
                    }else {
                        ArrayList<Integer> ruleValues = new ArrayList<>();
                        ruleValues.add(ruleIntArray[1]);
                        rules.put(ruleIntArray[0], ruleValues);
                    if (line.trim().isEmpty()) {
                        continue;

                        }
                    
                    }System.out.println(rules);
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readTheRest(String line) {
        
    }
}
