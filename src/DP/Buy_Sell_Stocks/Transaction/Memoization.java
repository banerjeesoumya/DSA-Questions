package DP.Buy_Sell_Stocks.Transaction;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        int[] prices1 = {1, 3, 2, 8, 4, 9};
        int fee1 = 2;
        System.out.println("Example 1 Output: " + maxProfit(prices1, fee1)); // Expected: 8

        int[] prices2 = {1, 3, 7, 5, 10, 3};
        int fee2 = 3;
        System.out.println("Example 2 Output: " + maxProfit(prices2, fee2)); // Expected: 6
    }
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp(0, 1, fee, n, prices, dp);
    }
    public static int dp(int i, int buy, int fee, int n, int[] arr, int[][] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-arr[i] + dp(i + 1, 0, fee, n, arr, dp)), (0 + dp(i + 1, 1, fee, n, arr, dp)));
        } else {
            profit = Math.max((arr[i] - fee + dp(i + 1, 1, fee, n, arr, dp)), (0 + dp(i + 1, 0, fee, n, arr, dp)));
        }
        dp[i][buy] = profit;
        return profit;
    }
}
