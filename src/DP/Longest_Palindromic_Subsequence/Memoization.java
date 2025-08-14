package DP.Longest_Palindromic_Subsequence;

public class Memoization {
    public static void main(String[] args) {
        String s1 = "bbbab";
        System.out.println("Longest Palindromic Subsequence length: " + longestPalindromeSeq(s1)); // Output: 4

        String s2 = "cbbd";
        System.out.println("Longest Palindromic Subsequence length: " + longestPalindromeSeq(s2)); // Output: 2

    }
    public static int longestPalindromeSeq(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        return dp(n, n, s, s2);
    }
    public static int dp(int i, int j, String s, String s2) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (s.charAt(i - 1) == s2.charAt(j - 1)) {
            return 1 + dp(i - 1, j - 1, s, s2);
        } else {
            return 0 + Math.max(dp(i - 1, j, s, s2), dp(i, j - 1, s, s2));
        }
    }
}
