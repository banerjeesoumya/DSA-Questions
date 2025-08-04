package DP.Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};

        System.out.println("Output for nums1: " + lengthOfLIS(nums1)); // Expected: 4
        System.out.println("Output for nums2: " + lengthOfLIS(nums2)); // Expected: 4
        System.out.println("Output for nums3: " + lengthOfLIS(nums3)); // Expected: 1
    }
    public static int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp(0, -1, n, arr, dp);
    }
    public static int dp (int i, int prev_ind, int n, int[] arr, int[][] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i][prev_ind + 1] != -1) {
            return dp[i][prev_ind + 1];
        }
        int len = 0 + dp(i + 1, prev_ind, n, arr, dp);
        if ((prev_ind == -1) || (arr[i] > arr[prev_ind])) {
            len = Math.max(len, 1 + dp(i + 1, i, n, arr, dp));
        }
        dp[i][prev_ind + 1] = len;
        return len;
    }
}
