package DP.EditDistances;

public class Tabulation {
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
    public static int editDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
