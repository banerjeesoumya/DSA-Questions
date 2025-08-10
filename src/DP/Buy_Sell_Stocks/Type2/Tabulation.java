package DP.Buy_Sell_Stocks.Type2;

import java.util.Arrays;

public class Tabulation {
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
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[n][0] = dp[n][1] = 0;
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    profit = Math.max((-prices[i] + dp[i + 1][0]), (0 + dp[i + 1][1]));
                } else {
                    profit = Math.max((prices[i] + dp[i + 1][1]), (0 + dp[i + 1][0]));
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
