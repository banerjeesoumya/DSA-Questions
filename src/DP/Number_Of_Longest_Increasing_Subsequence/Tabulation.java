package DP.Number_Of_Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Tabulation {
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 3, 5, 4, 7},          // Expected: 2
                {2, 2, 2, 2, 2},          // Expected: 5
                {1, 2, 4, 3, 5, 4, 7, 2}, // Expected: 3
                {1},                      // Expected: 1
                {},                       // Expected: 0
                {1, 2, 3, 4, 5},          // Expected: 1
                {5, 4, 3, 2, 1}           // Expected: 5
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int result = findNumberOfLIS(nums);
            System.out.println("Test Case " + (i + 1) + ": " + Arrays.toString(nums));
            System.out.println("Number of Longest Increasing Subsequences: " + result);
            System.out.println("--------------------------------------------------");
        }
    }
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int prev_ind = 0; prev_ind < i; prev_ind++) {
                if ((nums[prev_ind] < nums[i]) && (dp[i] < 1 + dp[prev_ind])) {
                    dp[i] = 1 + dp[prev_ind];
                    count[i] = count[prev_ind];
                } else if ((nums[prev_ind] < nums[i]) && (dp[i] == 1 + dp[prev_ind])) {
                    count[i] = count[i] + count[prev_ind];
                }
            }
            max = Math.max(max, dp[i]);
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                c = c + count[i];
            }
        }
        return c;
    }
}
