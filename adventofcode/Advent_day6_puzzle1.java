package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Advent_day6_puzzle1 {

    public static void main(String[] args) {
        List<List<Character>> grid = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\harrison.knight\\VS Code Projects\\resources\\day6example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<Character> row = new ArrayList<>();
                for (char c : line.toCharArray()) {
                    row.add(c);
                }
                grid.add(row);
            }
            findStart(grid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void findStart(List<List<Character>> grid) {
        char replacement = 'X';
        char obstacle = '#';
        int directions[][]
                = { //[0][1]
                    {1, 0}, // [0]right
                    {0, 1}, //[1] down
                    {-1, 0}, //[2]left
                    {0, -1} //[3]up
                };

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                int row = j;
                int column = i;
                if (grid.get(column).get(row) == '^') {
                    int newRow = row + directions[3][0];
                    int newCol = column + directions[3][1];
                    while (newRow >= 0 && newRow < grid.get(0).size() && newCol >= 0 && newCol < grid.size() && grid.get(newCol).get(newRow) != '#') {
                        grid.get(newCol).set(newRow, replacement);
                        newRow = newRow + directions[3][0];
                        newCol = newCol + directions[3][1];
                    }
                }
            }
        }
        System.out.println(grid);
    }

    static void turnEast(List<List<Character>> grid, int[][] directions, int i, int j) {

        int uniquePaths = 0;

        for (int yAxisStart = i; yAxisStart < grid.size(); yAxisStart++) {
            for (int xAxisStart = j; xAxisStart < grid.get(i).size(); xAxisStart++) {
                try {

                } catch (IndexOutOfBoundsException e) {
                    //do nothing
                }
            }
        }
        System.out.println("Unique paths: " + uniquePaths);

    }

    static void turnSouth(List<List<Character>> grid, int[][] directions, int i, int j) {

    }

    static void turnWest(List<List<Character>> grid, int[][] directions, int i, int j) {

    }

    static void turnNorth(List<List<Character>> grid, int[][] directions, int i, int j) {

    }
}
