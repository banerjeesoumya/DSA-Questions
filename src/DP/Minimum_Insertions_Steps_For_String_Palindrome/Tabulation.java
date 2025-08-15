package DP.Minimum_Insertions_Steps_For_String_Palindrome;

public class Tabulation {
    public static void main(String[] args) {
        String[] testCases = {
                "race",       // Expected: 3 ("ecarace")
                "a",          // Expected: 0 (already a palindrome)
                "abcda",      // Expected: 2 ("adcba" → "abcdcba")
                "leetcode",   // Expected: 5
                "abca"        // Expected: 1 ("abcba")
        };

        for (String s : testCases) {
            int result = minInsertions(s);
            System.out.println("Minimum insertions for \"" + s + "\": " + result);
        }
    }
    public static int minInsertions(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[n][n];
    }
}
