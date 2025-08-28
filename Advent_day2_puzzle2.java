import java.io.*;
import java.util.*;

public class Advent_day2_puzzle2 {

    public static void main(String[] args) {
        String filename = "exampledata.txt";
        List<List<Integer>> grid = new ArrayList<>();
        Counter unsafe = new Counter();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.trim().split("\\s+");
                List<Integer> row = new ArrayList<>();
                for (String token : tokens) {
                    row.add(Integer.parseInt(token));
                }
                grid.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        iterateGrid(grid, unsafe);
        System.out.println("Unsafe rows: " + unsafe.value);
    }

    static void iterateGrid(List<List<Integer>> grid, Counter unsafe) {
        for (List<Integer> row : grid) {
            if (row.size() < 2) continue;
            boolean isIncreasing = false;
            boolean isDecreasing = false;

            int diff = row.get(1) - row.get(0);
            if (diff > 0) isIncreasing = true;
            else if (diff < 0) isDecreasing = true;

            findProblems(new ArrayList<>(row), 0, isIncreasing, isDecreasing, unsafe);
        }
    }

    static void findProblems(List<Integer> row, int dampener, boolean isIncreasing, boolean isDecreasing, Counter unsafe) {
        for (int i = 1; i < row.size(); i++) {
            int diff = row.get(i) - row.get(i - 1);

            boolean problem = (isIncreasing && (diff > 3 || diff <= 0)) ||
                              (isDecreasing && (diff < -3 || diff >= 0));

            if (problem) {
                dampener++;
                row.remove(i);
                if (dampener < 2) {
                    findProblems(row, dampener, isIncreasing, isDecreasing, unsafe);
                } else {
                    unsafe.value++;
                }
                break;
            }
        }
    }

    static class Counter {
        int value = 0;
    }
}
