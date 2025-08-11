package DP.Buy_Sell_Stocks.Transaction;

import java.util.Arrays;

public class Tabulation {
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
        dp[n][0] = dp[n][1] = 0;
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy ++) {
                if (buy == 1) {
                    profit = Math.max((-prices[i] + dp[i + 1][0]), (0 + dp[i + 1][1]));
                } else {
                    profit = Math.max((prices[i] - fee + dp[i + 1][1]), (0 + dp[i + 1][0]));
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
