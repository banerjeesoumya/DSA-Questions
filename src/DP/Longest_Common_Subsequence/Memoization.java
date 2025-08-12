package DP.Longest_Common_Subsequence;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        String text1a = "abcde";
        String text2a = "ace";
        System.out.println("Input: text1 = \"" + text1a + "\", text2 = \"" + text2a + "\"");
        System.out.println("Output: " + longestCommonSubsequence(text1a, text2a));

        String text1b = "abc";
        String text2b = "abc";
        System.out.println("Input: text1 = \"" + text1b + "\", text2 = \"" + text2b + "\"");
        System.out.println("Output: " + longestCommonSubsequence(text1b, text2b));

        String text1c = "abc";
        String text2c = "def";
        System.out.println("Input: text1 = \"" + text1c + "\", text2 = \"" + text2c + "\"");
        System.out.println("Output: " + longestCommonSubsequence(text1c, text2c));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp(m - 1, n - 1, text1, text2, dp);
    }
    public static int dp(int i, int j, String text1, String text2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + dp(i - 1, j - 1, text1, text2, dp);
        } else {
            return 0 + Math.max(dp(i - 1, j, text1, text2, dp), dp(i, j - 1, text1, text2, dp));
        }
    }
}
