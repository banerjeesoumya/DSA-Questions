package DP.Longest_Common_Subsequence;

public class Tabulation {
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
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i ++ ) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j ++ ) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
