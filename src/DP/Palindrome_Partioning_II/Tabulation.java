package DP.Palindrome_Partioning_II;

import java.util.Arrays;

public class Tabulation {
    public static void main(String[] args) {
        String[] testCases = {"aab", "a", "ab", "banana", "noonabbad"};

        for (String s : testCases) {
            int result = minCut(s);
            System.out.println("Minimum cuts needed for \"" + s + "\" is: " + result);
        }
    }
    public static int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 0);
        for (int i = s.length() - 1; i >= 0; i --) {
            int min = Integer.MAX_VALUE;
            for (int k = i; k < s.length(); k ++) {
                if (isPalindrome(i, k, s)) {
                    int cost = 1 + dp[k + 1];
                    min = Math.min(cost, min);
                }
            }
            dp[i] = min;
        }
        return dp[0] - 1;
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
