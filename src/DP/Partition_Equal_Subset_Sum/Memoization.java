package DP.Partition_Equal_Subset_Sum;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        boolean result = canPartition(arr);
        System.out.println("Can partition: " + result);
    }
    public static boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int[][] dp = new int[n][sum / 2 + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return dp(n - 1, arr, sum / 2, dp);
    }
    public static boolean dp(int i, int[] arr, int tar, int[][] dp) {
        if (tar == 0) {
            return true;
        }
        if (i == 0) {
            return arr[0] == tar;
        }
        if (dp[i][tar] != -1) {
            return dp[i][tar] == 0 ? false : true;
        }
        boolean notTake = dp(i - 1, arr, tar, dp);
        boolean take = false;
        if (tar >= arr[i]) {
            take = dp(i - 1, arr, tar - arr[i], dp);
        }
        dp[i][tar] = notTake || take ? 1 : 0;
        return notTake || take;
    }
}
