package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Advent_day6_puzzle2 {

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
                if (grid.get(i).get(j) == '^') { //finds the start or current position of ^
                    int startRow = j;
                    int startCol = i;
                    placeObstacle(grid, directionsMap, startCol, startRow, direction);
                }
            }
        }
        // System.out.println(grid);
    }

    static void placeObstacle(List<List<Character>> grid, int[][] directionsMap, int startCol, int startRow, int direction) {
        char replacement = '#';
        checkForLoop:
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (j > 1) {
                    grid.get(i).set(j, replacement); //place an obstacle at i col and j row
                    grid.get(i).set(j - 1, '.'); //change the previous obstacle back to normal
                    findPath(grid, directionsMap, startCol, startRow, replacement, direction, replacement);
                }else {
                    grid.get(i).set(j, replacement); //put an obstacle in the grid
                    findPath(grid, directionsMap, startCol, startRow, replacement, direction, replacement);
                }
            }
        }
    }

    static void findPath(List<List<Character>> grid, int[][] directionsMap, int startCol, int startRow, char obstacle, int direction, char replacement) {
        direction = 0; //reset back to heading up/north
        loop:
        for (int i = startCol; i < grid.size(); startCol++) {
            for (int j = startRow; startRow < grid.get(startCol).size(); startRow++) {
                grid.get(startCol).set(startRow, replacement); //replace current position with 'X'
                while (startRow < grid.get(startCol).size() || startCol < grid.size()) {
                    try {
                        if (grid.get(startCol + directionsMap[direction][1]).get(startRow + directionsMap[direction][0]) != obstacle) { //if obstacle is not found in next step
                            grid.get(startCol + directionsMap[direction][1]).set(startRow + directionsMap[direction][0], replacement); //replace next position with 'X'
                            startRow = startRow + directionsMap[direction][0]; //take a step in the X direction
                            startCol = startCol + directionsMap[direction][1]; //take a step in the Y direction
                            // printGrid(grid);
                        } else { //if obstacle is found
                            if (direction == 3) { //if currently heading left/west
                                direction = 0; //reset back to heading up/north
                                // printGrid(grid);
                            } else {
                                direction++;
                                // printGrid(grid);
                            }

                        }
                    } catch (IndexOutOfBoundsException e) {
                        break;
                    }
                }
            }
        }
    }
}
