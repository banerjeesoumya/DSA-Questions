package DP.EditDistances;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("Edit Distance between \"" + word1 + "\" and \"" + word2 + "\": " + editDistance(word1, word2));

        word1 = "intention";
        word2 = "execution";
        System.out.println("Edit Distance between \"" + word1 + "\" and \"" + word2 + "\": " + editDistance(word1, word2));

        word1 = "";
        word2 = "abc";
        System.out.println("Edit Distance between \"" + word1 + "\" and \"" + word2 + "\": " + editDistance(word1, word2));

        word1 = "abc";
        word2 = "";
        System.out.println("Edit Distance between \"" + word1 + "\" and \"" + word2 + "\": " + editDistance(word1, word2));

        word1 = "abc";
        word2 = "abc";
        System.out.println("Edit Distance between \"" + word1 + "\" and \"" + word2 + "\": " + editDistance(word1, word2));

    }
    public static int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
//        for (int[] rows : dp) {
//            Arrays.fill(rows, -1);
//        }
//        return dp(m, n, str1, str2, dp);
    }
    public static int dp(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = dp(i - 1, j - 1, s1, s2, dp);
        } else {
            return dp[i][j] = 1 + Math.min(dp(i, j - 1, s1, s2, dp), Math.min(dp(i - 1, j, s1, s2, dp), dp(i - 1, j - 1, s2, s2, dp)));
        }
    }
}
