package leetcode_stuff;

import java.util.ArrayList;
import java.util.List;

/*Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]] */

public class leetcode6 {

    public static void main(String[] args) {
        int numRows = 7;
        generate(numRows);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        pascalsTriangle.add(new ArrayList<>(List.of(1)));

        
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1); //the new row always starts with 1
            innerloop:
            for (int j = 0; j < pascalsTriangle.get(i).size(); j++) {
                if (j == pascalsTriangle.get(i).size()-1){ //if the end of the row, end with 1 and break the loop
                    newRow.add(1);
                    pascalsTriangle.add(newRow);
                    break innerloop;
                } else{
                int sum = pascalsTriangle.get(i).get(j) + pascalsTriangle.get(i).get(j+1);
                newRow.add(sum);
                }
            }
        }
        for (int i = 0; i < pascalsTriangle.size(); i++){ //a loop to print it pretty
        System.out.println(pascalsTriangle.get(i)); 
        }
        return pascalsTriangle;
    }
}