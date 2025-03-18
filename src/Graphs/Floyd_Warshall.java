package Graphs;

import java.util.Arrays;

public class Floyd_Warshall {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 43},
                {1, 0, 6},
                {-1, -1, 0}
        };

        Floyd_Warshall fw = new Floyd_Warshall();
        fw.shortestDistance(matrix);

        System.out.println("Shortest Distance Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    public void shortestDistance(int[][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j <matrix.length; j ++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e9);
                }
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int k = 0; k < matrix.length; k ++) {
            for (int  i = 0; i < matrix.length; i ++) {
                for (int j = 0; j < matrix.length; j ++) {
                    matrix[i][j] = Math.min(matrix[i][j], (matrix[i][k] + matrix[k][j]));
                }
            }
        }
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
