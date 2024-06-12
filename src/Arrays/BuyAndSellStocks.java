package Arrays;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
        int profit = maxProfit(arr);
        System.out.println(profit);
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
