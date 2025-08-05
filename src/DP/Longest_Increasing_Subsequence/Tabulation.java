package DP.Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Tabulation {
    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};

        System.out.println("Output for nums1: " + lengthofLIS(nums1)); // Expected: 4
        System.out.println("Output for nums2: " + lengthofLIS(nums2)); // Expected: 4
        System.out.println("Output for nums3: " + lengthofLIS(nums3)); // Expected: 1
    }
    public static int lengthofLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < n; i ++) {
            for (int prev_ind = 0; prev_ind < i; prev_ind ++) {
                if (arr[prev_ind] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[prev_ind] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
