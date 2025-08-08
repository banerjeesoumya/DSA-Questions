package DP.Longest_Bitonic_Subsequence;

import java.util.Arrays;

public class Tabulation {
    public static void main(String[] args) {
        int[][] testCases = {
                {5, 1, 4, 2, 3, 6, 8, 7},           // Expected: 6
                {10, 20, 30, 40, 50, 40, 30, 20},   // Expected: 8
                {1, 2, 3, 4, 5},                    // Expected: 5 (strictly increasing)
                {5, 4, 3, 2, 1},                    // Expected: 5 (strictly decreasing)
                {1, 11, 2, 10, 4, 5, 2, 1}          // Expected: 6 (classic bitonic)
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            int result = longestBitonicSubsequence(arr);
            System.out.println("Test Case " + (i + 1) + ": " + Arrays.toString(arr));
            System.out.println("Longest Bitonic Subsequence Length: " + result);
            System.out.println("--------------------------------------------------");
        }

    }
    public static int longestBitonicSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for (int i = 0; i < n; i++) {
            for (int prev_ind = 0; prev_ind < i; prev_ind++) {
                if (arr[prev_ind] < arr[i] && dp1[i] < 1 + dp1[prev_ind]) {
                    dp1[i] = dp1[prev_ind] + 1;
                }
            }
        }
        int[] dp2 = new int[n];
        int max = 1;
        Arrays.fill(dp2, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int prev_ind = n - 1; prev_ind > i; prev_ind--) {
                if (arr[prev_ind] < arr[i] && dp2[i] < 1 + dp2[prev_ind]) {
                    dp2[i] = dp2[prev_ind] + 1;
                }
            }
            max = Math.max(max, dp2[i] + dp1[i] - 1);
        }
        return max;
    }
}
