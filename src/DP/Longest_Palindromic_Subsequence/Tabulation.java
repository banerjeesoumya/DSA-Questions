package DP.Longest_Palindromic_Subsequence;

public class Tabulation {
    public static void main(String[] args) {
        String s1 = "bbbab";
        System.out.println("Longest Palindromic Subsequence length: " + longestPalindromeSubseq(s1)); // Output: 4

        String s2 = "cbbd";
        System.out.println("Longest Palindromic Subsequence length: " + longestPalindromeSubseq(s2)); // Output: 2

    }
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}
