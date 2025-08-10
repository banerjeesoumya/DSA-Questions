package DP.Buy_Sell_Stocks.Type2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};

        System.out.println("Max Profit (Example 1): " + maxProfit(prices1)); // Expected: 7
        System.out.println("Max Profit (Example 2): " + maxProfit(prices2)); // Expected: 4
        System.out.println("Max Profit (Example 3): " + maxProfit(prices3)); // Expected: 0
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return dp(0, 1, n, prices, dp);
    }
    private static int dp(int i, int buy, int n, int[] prices, int[][] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-prices[i] + dp(i + 1, 0, n, prices, dp)), (0 + dp(i + 1, 1, n, prices, dp)));
        } else {
            profit = Math.max((prices[i] + dp(i + 1, 1, n, prices, dp)), (0 + dp(i + 1, 0, n, prices, dp)));
        }
        dp[i][buy] = profit;
        return profit;
    }
}
