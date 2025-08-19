package DP.WildcardMatching;

import java.util.Arrays;

public class Memoization {
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
        for (boolean[] rows : dp) {
            Arrays.fill(rows, false);
        }
        return dp(m, n, s, p, dp);
    }
    public static boolean dp (int i, int j, String s, String p, boolean[][] dp) {
        if (i == 0 && j == 0) {
            return true;
        }
        if (j == 0 && i > 0) {
            return false;
        }
        if (i == 0 && j > 0) {
            for (int ind = 1; ind <= j; ind ++) {
                if (p.charAt(ind - 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (dp[i][j] != false) {
            return dp[i][j];
        }
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            return dp[i][j] = dp(i - 1, j - 1, s, p, dp);
        } if (p.charAt(j - 1) == '*') {
            return dp[i][j] = dp(i - 1, j, s, p, dp) | dp(i, j - 1, s, p, dp);
        }
        return dp[i][j] = false;
    }
}
