package DP.Partition_Array_For_Maximum_Sum;

import java.util.Arrays;

public class Tabulation {
    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;

        int result = maxSumAfterPartition(arr, k);
        System.out.println("Maximum sum after partitioning = " + result);
    }
    public static int maxSumAfterPartition(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for (int i = n - 1; i >= 0; i --) {
            int len = 0;
            int maxEl = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
             for (int j = i; j < Math.min(i + k, n); j ++) {
                 len ++;
                 maxEl = Math.max(maxEl, arr[j]);
                 int sum = (len * maxEl) + dp[j + 1];
                 max = Math.max(sum, max);
             }
             dp[i] = max;
        }
        return dp[0];
    }
}
