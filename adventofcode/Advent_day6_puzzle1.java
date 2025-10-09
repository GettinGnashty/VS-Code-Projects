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
                    int startRow = j;
                    int startCol = i;
                    turn(grid, directionsMap, startCol, startRow, replacement, obstacle, direction, uniquePath);
                }
            }
        }
        System.out.println(grid);
    }

    static void turn(List<List<Character>> grid, int[][] directionsMap, int startCol, int startRow, char replacement, char obstacle, int direction, int uniquePath) {
        for (int i = startCol; i < grid.size(); startCol++) {
            for (int j = startRow; startRow < grid.get(startCol).size(); startRow++) {
                while (grid.get(startCol).get(startRow) != obstacle) {
                    try {

                        grid.get(startCol).set(startRow, replacement);
                        startRow = startRow + directionsMap[direction][0];
                        startCol = startCol + directionsMap[direction][1];
                        if (grid.get(startCol + directionsMap[direction][1]).get(startRow + directionsMap[direction][0]) == obstacle) { //if obstacle is found
                            if (direction == 3) { //if currently heading left/west
                                direction = 0; //reset back to heading up/north
                                turn(grid, directionsMap, startCol, startRow, replacement, obstacle, direction, uniquePath);
                            } else {
                                direction++;
                                turn(grid, directionsMap, startCol, startRow, replacement, obstacle, direction, uniquePath);
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {

                        for (int col = 0; i < grid.size(); col++) {
                            for (int row = 0; j < grid.get(col).size(); row++) {
                                if (grid.get(col).get(row) == replacement) {
                                    uniquePath++;
                                }
                            }
                        }
                        System.out.println(uniquePath);
                    }
                    for (List<Character> r : grid) {
                        System.out.println(r);
                    }
                    System.out.println();
                }
            }
        }
    }
}
