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
        int uniquePath = 0;
        char replacement = 'X';
        char obstacle = '#';
        int direction = 0;
        int directionsMap[][]
                = { //[0][1]
                    {0, -1}, //[0]up
                    {1, 0}, // [1]right
                    {0, 1}, //[2] down
                    {-1, 0} //[3]left
                };

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == '^') {
                    int currentRow = j;
                    int currentCol = i;
                    turn(grid, directionsMap, currentCol, currentRow, replacement, obstacle, direction, uniquePath);
                }
            }
        }
        System.out.println(grid);
    }

    static void turn(List<List<Character>> grid, int[][] directionsMap, int currentCol, int currentRow, char replacement, char obstacle, int direction, int uniquePath) {
        direction = 0; //reset back to heading up/north
        for (int i = currentCol; i < grid.size(); currentCol++) {
            for (int j = currentRow; currentRow < grid.get(currentCol).size(); currentRow++) {
                while (currentRow < grid.get(currentCol).size() && currentCol < grid.size()) {
                    try {
                        if (grid.get(currentCol + directionsMap[direction][1]).get(currentRow + directionsMap[direction][0]) != obstacle) { //if obstacle is not found in next step
                            grid.get(currentCol).set(currentRow, replacement); //replace current position with 'X'
                            currentRow = currentRow + directionsMap[direction][0];
                            currentCol = currentCol + directionsMap[direction][1];
                        } else { //if obstacle is found
                            if (direction == 3) { //if currently heading left/west
                                direction = 0; //reset back to heading up/north
                            } else {
                                direction++;
                            }

                        }
                    } catch (IndexOutOfBoundsException e) {
                        countUniquePaths(grid);
                    }
                }
            }
        }
    }

    static void printGrid(List<List<Character>> grid) {
        for (List<Character> r : grid) {
            System.out.println(r);
        }
        System.out.println();
    }

    static void countUniquePaths(List<List<Character>> grid) {
        int uniquePath = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 'X') {
                    uniquePath++;
                }
            }
        }
        System.out.println("Total unique paths: " + uniquePath);
    }
}
