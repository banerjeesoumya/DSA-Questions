package DP.Min_Delete_Opr_For_Two_Strings;

public class Tabulation {
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
        for (int i = 0; i <= m; i ++) {
            dp[i][0] = 0;
        }
        for (int j = 0 ; j <= n; j ++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * (dp[m][n]);
    }
}
