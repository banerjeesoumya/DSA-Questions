package DP.Partition_Array_For_Maximum_Sum;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;

        int result = maxSumAfterPartitioning(arr, k);
        System.out.println("Maximum sum after partitioning = " + result);
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dp(0, n, arr, k, dp);
    }
    public static int dp(int i, int j, int[] arr, int lim, int[] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int len = 0;
        int maxEl = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k = i; k < Math.min(i + lim, j); k++) {
            len ++;
            maxEl = Math.max(arr[k], maxEl);
            int sum = (len * maxEl) + dp(k + 1, arr.length, arr, lim, dp);
            max = Math.max(max, sum);
        }
        dp[i] = max;
        return max;
    }
}
