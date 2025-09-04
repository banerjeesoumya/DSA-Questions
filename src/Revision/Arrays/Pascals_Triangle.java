package Revision.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    public static void main(String[] args) {
        // Example 1: numRows = 5
        int numRows1 = 5;
        List<List<Integer>> triangle1 = generate(numRows1);
        System.out.println("Pascal's Triangle with " + numRows1 + " rows:");
        printTriangle(triangle1);

        System.out.println("\n--------------------------\n");

        // Example 2: numRows = 1
        int numRows2 = 1;
        List<List<Integer>> triangle2 = generate(numRows2);
        System.out.println("Pascal's Triangle with " + numRows2 + " row:");
        printTriangle(triangle2);
    }
    private static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = result.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 0; j < previousRow.size() - 1; j++) {
                currRow.add(previousRow.get(j) + previousRow.get(j + 1));
            }
            currRow.add(1);
            result.add(currRow);
        }
        return result;
    }
}
