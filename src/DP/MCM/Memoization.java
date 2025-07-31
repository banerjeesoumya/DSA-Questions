package DP;

import java.util.Arrays;

public class MCM_Memoization {
    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};

        int minMultiplications = matrixMultiplication(arr);

        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }


    public static int matrixMultiplication(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return dp(arr, 1, arr.length - 1, dp);
    }
    public static int dp(int[] arr, int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k ++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + dp(arr, i, k, dp) + dp(arr, k + 1, j, dp);
            min = Math.min(min, steps);
        }
        return min;
    }
}
