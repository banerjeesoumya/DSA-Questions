package DP;

public class MCM_Tabulation {
    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};

        int minMultiplications = matrixMultiplication(arr);

        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }
    public static int matrixMultiplication (int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = 0;
        }
        for (int i = arr.length - 1; i >= 1; i --) {
            for (int j = i + 1; j < arr.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][arr.length - 1];
    }
}
