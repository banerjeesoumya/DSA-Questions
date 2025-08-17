package DP.Distinct_Subsequences;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        String s1 = "rabbbit";
        String s2 = "rabbit";
        System.out.println("Output: " + numDistinct(s1, s2)); // Expected: 3

        s1 = "babgbag";
        s2 = "bag";
        System.out.println("Output: " + numDistinct(s1, s2)); // Expected: 5
    }
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int [m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp(m , n, s, t, dp);
    }
    public static int dp(int i, int j, String s1, String s2, int[][] dp) {
        if (j == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = dp(i - 1, j - 1, s1, s2, dp) + dp(i - 1, j, s1, s2, dp);
        } else {
            return dp[i][j] = dp(i - 1, j, s1, s2, dp);
        }
    }
}
