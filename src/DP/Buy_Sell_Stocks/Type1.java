package DP.Buy_Sell_Stocks;

public class Type1 {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int profit1 = maxProfit(prices1);
        System.out.println("Max Profit (Example 1): " + profit1); // Expected: 5

        // Example 2
        int[] prices2 = {7, 6, 4, 3, 1};
        int profit2 = maxProfit(prices2);
        System.out.println("Max Profit (Example 2): " + profit2); // Expected: 0

    }
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }
}
