package DP.Buy_Sell_Stocks.Type3;

public class Tabulation {
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
        int[][][] dp = new int[n + 1][2][3];
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy ++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        profit = Math.max((-prices[i] + dp[i + 1][0][cap]), (0 + dp[i + 1][1][cap]));
                    } else {
                        profit = Math.max((prices[i] + dp[i + 1][1][cap - 1]), (0 + dp[i + 1][0][cap]));
                    }
                    dp[i][buy][cap] = profit;   
                }
            }
        }
        return dp[0][1][2];
    }
}
