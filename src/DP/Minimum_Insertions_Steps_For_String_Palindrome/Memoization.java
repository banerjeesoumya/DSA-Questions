package DP.Minimum_Insertions_Steps_For_String_Palindrome;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        String[] testCases = {
                "race",       // Expected: 3 ("ecarace")
                "a",          // Expected: 0 (already a palindrome)
                "abcda",      // Expected: 2 ("adcba" → "abcdcba")
                "leetcode",   // Expected: 5
                "abca"        // Expected: 1 ("abcba")
        };

        for (String s : testCases) {
            int result = minInsertions(s);
            System.out.println("Minimum insertions for \"" + s + "\": " + result);
        }
    }
    public static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        String s2 = new StringBuilder(s).reverse().toString();
        return n - dp(n, n, s, s2, dp);
    }
    public static int dp(int i, int j, String s, String s2, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 + dp(i - 1, j - 1, s, s2, dp);
        } else {
            return dp[i][j] = 0 + Math.max(dp(i - 1, j, s, s2, dp), dp(i, j - 1, s, s2, dp));
        }
    }
}
