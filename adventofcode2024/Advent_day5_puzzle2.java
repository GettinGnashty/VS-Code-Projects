package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Advent_day5_puzzle2 {

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
        getPages(rules, pages);
    }

    static void getPages(HashMap<Integer, ArrayList<Integer>> rules,
            List<List<Integer>> pages) {
        List<List<Integer>> incorrectPages = new ArrayList<>();

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
                                safeArray = false; //if key does not contain value, add array to incorrect pages
                                incorrectPages.add(currentArray);
                                break innerLoop;
                            }
                        } else { //if key does not exist, skip array and go next
                            safeArray = false;
                            incorrectPages.add(currentArray);
                            break innerLoop;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        break innerLoop;
                    }
                }
            }
        }
        sortArrays(incorrectPages, rules);
    }

    static void sortArrays(List<List<Integer>> incorrectPages, HashMap<Integer, ArrayList<Integer>> rules) {
        List<List<Integer>> incorrectPagesSorted = new ArrayList<>();
        for (int i = 0; i < incorrectPages.size(); i++) {
            List<Integer> currentArray = incorrectPages.get(i);

            for (int j = 0; j < currentArray.size(); j++) {
                for (int k = 0; k < currentArray.size(); k++) {
                    try {
                        int currentNumber = incorrectPages.get(i).get(j);
                        int nextNumber = incorrectPages.get(i).get(k);
                        if (rules.containsKey(incorrectPages.get(i).get(j))) {
                            if (rules.get(currentNumber).contains(nextNumber)) { //rule check
                                //do nothing, its fine
                            } else {
                                Collections.swap(currentArray, j, k); //swap the numbers at each index
                            }
                        } else {
                            Collections.swap(currentArray, j, k); //if key doesn't exist, swap number at each index
                        }

                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            }
            incorrectPagesSorted.add(currentArray); //add the sorted array to an array (2-D array)
        }
        findInt(incorrectPagesSorted);

    }

    static int findInt(List<List<Integer>> incorrectPagesSorted) {
        int total = 0;
        for (int i = 0; i < incorrectPagesSorted.size(); i++) {
            List<Integer> currentArray = incorrectPagesSorted.get(i);
            int getMiddleIndex = currentArray.size() / 2; //divide size of array by 2, gets the middle index
            total += currentArray.get(getMiddleIndex);
        }
        System.out.println("Total: " + total);
        return total;
    }
}
