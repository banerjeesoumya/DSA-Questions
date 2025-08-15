package DP.Min_Delete_Opr_For_Two_Strings;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println("Minimum steps to make \"" + word1 + "\" and \"" + word2 + "\" the same: " + minDistance(word1, word2));

        word1 = "leetcode";
        word2 = "etco";
        System.out.println("Minimum steps to make \"" + word1 + "\" and \"" + word2 + "\" the same: " + minDistance(word1, word2));
    }
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return n + m - 2 * (dp(m, n, word1, word2, dp));
    }
    public static int dp(int i, int j, String word1, String word2, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return dp[i][j] = 1 + dp(i - 1, j - 1, word1, word2, dp);
        } else {
            return dp[i][j] = Math.max((dp(i - 1, j, word1, word2, dp)), dp(i, j - 1, word1, word2, dp));
        }
    }
}
