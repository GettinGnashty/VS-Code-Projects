package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Advent_day4_puzzle2 {

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
        int[][] directions = {
            {1, -1}, //[0] right up 🢅
            {-1, 1}, //[1] left down 🢇
            {-1, -1}, //[2] left up 🢄
            {1, 1}}; //[3] right down 🢆

        int xmasCounter = 0;
        char[] xmas = {'M', 'S'};
        char start = 'A';
        rowLoop:
        for (int i = 0; i < grid.size(); i++) {
            letterLoop:
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == start) { //find an 'A' first
                    xmasCounter = checkTop(grid, xmas, i, j, xmasCounter, directions);
                    xmasCounter = checkLeft(grid, xmas, i, j, xmasCounter, directions);
                    xmasCounter = checkBottom(grid, xmas, i, j, xmasCounter, directions);
                    xmasCounter = checkRight(grid, xmas, i, j, xmasCounter, directions);
                }
            }
        }
        System.out.println("Total XMAS's found: " + xmasCounter);
    }

    static int checkTop(List<List<Character>> grid, char[] xmas, int i, int j, int xmasCounter, int[][] directions) {
        int row = j; //need to maintain the i/j index but check the directions
        int column = i; //needs to be reset upon each iteration
        try {
            //checks for M on top
            if (grid.get(column + directions[0][1]).get(row + directions[0][0]) == xmas[0] //checks for M in topRight
            && grid.get(column + directions[1][1]).get(row + directions[1][0]) == xmas[1] //checks for S in bottomLeft
            && grid.get(column + directions[2][1]).get(row + directions[2][0]) == xmas[0] //checks for M in topLeft
            && grid.get(column + directions[3][1]).get(row + directions[3][0]) == xmas[1]) { //checks for S in bottomRight
                xmasCounter++;
            }
        } catch (IndexOutOfBoundsException e) {
            //do nothing

        }
        return xmasCounter;
    }

    static int checkLeft(List<List<Character>> grid, char[] xmas, int i, int j, int xmasCounter, int[][] directions) {
        int row = j; //need to maintain the i/j index but check the directions
        int column = i;
        try{
        //checks for M on left
            if (grid.get(column + directions[2][1]).get(row + directions[2][0]) == xmas[0] //checks for M in topLeft
            && grid.get(column + directions[3][1]).get(row + directions[3][0]) == xmas[1] //checks for S in bottomRight
            && grid.get(column + directions[1][1]).get(row + directions[1][0]) == xmas[0] //checks for M in bottomLeft
            && grid.get(column + directions[0][1]).get(row + directions[0][0]) == xmas[1]) { //checks for S in topRight
                xmasCounter++;
            }
        } catch (IndexOutOfBoundsException e) {
            //do nothing
        }
        return xmasCounter;
    }

    static int checkBottom(List<List<Character>> grid, char[] xmas, int i, int j, int xmasCounter, int[][] directions) {
        int row = j; //need to maintain the i/j index but check the directions
        int column = i;
        try{
        //checks for M on bottom
            if (grid.get(column + directions[1][1]).get(row + directions[1][0]) == xmas[0] //checks for M in bottomLeft
            && grid.get(column + directions[0][1]).get(row + directions[0][0]) == xmas[1] //checks for S in topRight
            && grid.get(column + directions[3][1]).get(row + directions[3][0]) == xmas[0] //checks for M in bottomRight
            && grid.get(column + directions[2][1]).get(row + directions[2][0]) == xmas[1]) { //checks for S in topLeft
                xmasCounter++;
            }
        } catch (IndexOutOfBoundsException e) {
            //do nothing
        }
        return xmasCounter;
    }

    static int checkRight(List<List<Character>> grid, char[] xmas, int i, int j, int xmasCounter, int[][] directions) {
        int row = j; //need to maintain the i/j index but check the directions
        int column = i;
        try{
        //checks for M on right
            if (grid.get(column + directions[3][1]).get(row + directions[3][0]) == xmas[0] //checks for M in bottomRight
            && grid.get(column + directions[2][1]).get(row + directions[2][0]) == xmas[1] //checks for S in topLeft
            && grid.get(column + directions[0][1]).get(row + directions[0][0]) == xmas[0] //checks for M in topRight
            && grid.get(column + directions[1][1]).get(row + directions[1][0]) == xmas[1]) { //checks for S in bottomLeft
                xmasCounter++;
            }
        } catch (IndexOutOfBoundsException e) {
            //do nothing
        }
        return xmasCounter;
    }
}
