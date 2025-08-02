package DP.Palindrome_Partioning_II;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        String[] testCases = {"aab", "a", "ab", "banana", "noonabbad"};

        for (String s : testCases) {
            int result = minCut(s);
            System.out.println("Minimum cuts needed for \"" + s + "\" is: " + result);
        }

    }
    public static int minCut(String s) {
        int[] dp = new int [s.length() + 1];
        Arrays.fill(dp, -1);
        return dp(0, s.length(), s, dp) - 1;
    }
    public static int dp(int i, int j, String s, int[] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (isPalindrome(i, k, s)) {
                int cost = 1 + dp(k + 1, j, s, dp);
                min = Math.min(min, cost);
            }
            dp[i] = min;
        }
        return min;
    }
    public static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}
