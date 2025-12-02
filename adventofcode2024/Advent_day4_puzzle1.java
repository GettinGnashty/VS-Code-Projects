package adventofcode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Advent_day4_puzzle1 {

    public static void main(String[] args) {
        List<List<Character>> grid = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\harrison.knight\\VS Code Projects\\resources\\day4.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<Character> row = new ArrayList<>();
                for (char c : line.toCharArray()) {
                    row.add(c);
                }
                grid.add(row);
            }
            wordSearch(grid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void wordSearch(List<List<Character>> grid) {
        int xmasCounter = 0;
        char[] xmas = {'M', 'A', 'S'};
        char start = 'X';
        rowLoop:
        for (int i = 0; i < grid.size(); i++) {
            letterLoop:
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == start) { //find an 'X' first
                    xmasCounter = checkWays(grid, xmas, i, j, xmasCounter);
                }
            }
        }
        System.out.println("Total XMAS's found: " + xmasCounter);
    }

    static int checkWays(List<List<Character>> grid, char[] xmas, int i, int j, int xmasCounter) {
        int[][] directions = {{1, 0}, //[0] right 🢂
        {-1, 0}, //[1] left 🢀
        {0, -1}, //[2] up 🢁
        {0, 1}, //[3] down 🢃
        {1, 1}, //[4] right down 🢆
        {-1, 1}, //[5] left down 🢇
        {1, -1}, //[6] right up 🢅
        {-1, -1}}; //[7] left up 🢄

        for (int directionsIndex = 0; directionsIndex < directions.length; directionsIndex++) {
            int row = j; //need to maintain the i/j index but check the directions
            int column = i;
            try {
                if (grid.get(column += directions[directionsIndex][1]).get(row += directions[directionsIndex][0]) == xmas[0]) { //checks for M
                    if (grid.get(column += directions[directionsIndex][1]).get(row += directions[directionsIndex][0]) == xmas[1]) { //checks for A
                        if (grid.get(column += directions[directionsIndex][1]).get(row += directions[directionsIndex][0]) == xmas[2]) { //checks for S
                            xmasCounter++;
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                //do nothing
            }
        }
        return xmasCounter;
    }
}
