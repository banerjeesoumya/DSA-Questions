package DP.WildcardMatching;

public class Tabulation {
    public static void main(String[] args) {
        String[][] testCases = {
                {"abcde", "a*de"},         // true: '*' matches "bc"
                {"abc", "a?c"},            // true: '?' matches 'b'
                {"abc", "a*d"},            // false: 'd' doesn't match
                {"", "*"},                 // true: '*' can match empty string
                {"", "?"},                 // false: '?' expects one character
                {"abc", "****"},           // true: multiple '*'s still match
                {"abc", "a*c?"},           // false: '?' expects one more character
                {"abc", "abc*"},           // true: '*' matches empty suffix
                {"abc", "*abc"},           // true: '*' matches empty prefix
                {"abc", "*a*b*c*"},        // true: '*'s can match empty or any sequence
        };

        for (String[] test : testCases) {
            String s = test[0];
            String p = test[1];
            boolean result = isMatch(s, p);
            System.out.printf("isMatch(\"%s\", \"%s\") = %b%n", s, p, result);
        }
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i ++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= n; j ++) {
            boolean flag = true;
            for (int ind = 1; ind <= j; ind ++) {
                if (p.charAt(ind - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}
