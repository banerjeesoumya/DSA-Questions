package DP.Buy_Sell_Stocks.Type4;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        // Example 1: Basic test case
        int[] prices1 = {3, 2, 6, 5, 0, 3};
        int k1 = 2;
        System.out.println("Max Profit (Example 1): " + maxProfit(k1, prices1)); // Expected: 7

        // Example 2: No transactions allowed
        int[] prices2 = {1, 2, 3, 4, 5};
        int k2 = 0;
        System.out.println("Max Profit (Example 2): " + maxProfit(k2, prices2)); // Expected: 0

        // Example 3: Prices decreasing
        int[] prices3 = {7, 6, 4, 3, 1};
        int k3 = 3;
        System.out.println("Max Profit (Example 3): " + maxProfit(k3, prices3)); // Expected: 0

        // Example 4: Large k value
        int[] prices4 = {1, 3, 2, 8, 4, 9};
        int k4 = 1000;
        System.out.println("Max Profit (Example 4): " + maxProfit(k4, prices4)); // Expected: 13

        // Example 5: Single day
        int[] prices5 = {5};
        int k5 = 1;
        System.out.println("Max Profit (Example 5): " + maxProfit(k5, prices5)); // Expected: 0
    }
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < 2; j ++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dp(0, 1, k, n, prices, dp);
    }
    public static int dp(int i, int buy, int k, int n, int[] arr, int[][][] dp) {
        if (i == n || k == 0) {
            return 0;
        }
        if (dp[i][buy][k] != -1) {
            return dp[i][buy][k];
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-arr[i] + dp(i + 1, 0, k, n, arr, dp)), (0 + dp(i + 1, 1, k, n, arr, dp)));
        } else {
            profit = Math.max((arr[i] + dp(i + 1, 1, k - 1, n, arr, dp)), (0 + dp(i + 1, 0, k, n, arr, dp)));
        }
        dp[i][buy][k] = profit;
        return profit;
    }
}
