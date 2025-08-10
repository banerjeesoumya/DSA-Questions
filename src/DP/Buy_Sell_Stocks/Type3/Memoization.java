package DP.Buy_Sell_Stocks.Type3;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};

        System.out.println("Example 1 Output: " + maxProfit(prices1)); // Expected: 6
        System.out.println("Example 2 Output: " + maxProfit(prices2)); // Expected: 4
        System.out.println("Example 3 Output: " + maxProfit(prices3)); // Expected: 0
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int [n][2][3];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < 2; j ++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dp(0, 1, 2, n, prices, dp);
    }
    public static int dp(int i, int buy, int cap, int n, int[] arr, int[][][] dp) {
        if (i == n || cap == 0){
            return 0;
        }
        if (dp[i][buy][cap] != -1) {
            return dp[i][buy][cap];
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-arr[i] + dp(i + 1, 0, cap, n, arr, dp)), (dp(i + 1, 1, cap, n, arr, dp)));
        } else {
            profit = Math.max((arr[i] + dp(i + 1, 1, cap - 1, n, arr, dp)), (dp(i + 1, 0, cap, n, arr, dp)));
        }
        dp[i][buy][cap] = profit;
        return profit;
    }
}
