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
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\harrison.knight\\VS Code Projects\\resources\\day5.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.length() <= 5) {
                    String[] ruleArray = line.split("\\|");
                    int[] ruleIntArray = new int[ruleArray.length];
                    ruleIntArray[0] = Integer.parseInt(ruleArray[0]);
                    ruleIntArray[1] = Integer.parseInt(ruleArray[1]);
                    if (rules.containsKey(ruleIntArray[0])) {  //if the key already exists within hashmap
                        rules.get(ruleIntArray[0]).add(ruleIntArray[1]); //add to the key's values
                    } else {
                        ArrayList<Integer> ruleValues = new ArrayList<>();
                        ruleValues.add(ruleIntArray[1]);
                        rules.put(ruleIntArray[0], ruleValues);
                        if (line.equals("")) { //keeps the reader going if it finds a blank line
                            continue;
                        }
                    }
                }
                //this is hard coded, probably bad
                if (line.length() > 5) {
                    String[] pagesArray = line.split(",");
                    List<Integer> page = new ArrayList<>();
                    for (String s : pagesArray) {
                        page.add(Integer.parseInt(s));
                    }
                    pages.add(page);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        checkNumbers(rules, pages);
    }

    static void checkNumbers(HashMap<Integer, ArrayList<Integer>> rules,
            List<List<Integer>> pages) {
        List<List<Integer>> correctPages = new ArrayList<>();

        outerLoop:
        for (int i = 0; i < pages.size(); i++) {
            List<Integer> currentArray = pages.get(i);
            boolean safeArray = true;
            innerLoop:
            while (safeArray == true) {
                for (int j = 0; j < pages.get(i).size(); j++) {
                    try {
                        int currentNumber = pages.get(i).get(j);
                        int nextNumber = pages.get(i).get(j + 1);
                        if (rules.containsKey(currentNumber)) { //throws null exception if i dont check for key first
                            if (rules.get(currentNumber).contains(nextNumber)) { //if key contains value
                                safeArray = true;
                            } else {
                                safeArray = false; //if key does not contain value, skip array and go next
                                break innerLoop;
                            }
                        }else { //if key does not exist, skip array and go next
                            safeArray = false;
                            break innerLoop;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        if (safeArray == true) {
                            correctPages.add(currentArray); //add the qualifying arrays to correctPages
                        }
                        break innerLoop;
                    }
                }
            }
        }
        findInt(correctPages);
    }

    static int findInt(List<List<Integer>> correctPages) {
        int total = 0;
        for (int i = 0; i < correctPages.size(); i++) {
            List<Integer> currentArray = correctPages.get(i);
            int getMiddleIndex = currentArray.size() / 2; //divide size of array by 2, gets the middle index
            total += currentArray.get(getMiddleIndex);
        }
        System.out.println("Total: " + total);
        return total;
    }
}
