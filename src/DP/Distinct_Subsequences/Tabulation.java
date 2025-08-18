package DP.Distinct_Subsequences;

public class Tabulation {
    public static void main(String[] args) {
        String s1 = "rabbbit";
        String s2 = "rabbit";
        System.out.println("Output: " + numDistinct(s1, s2)); // Expected: 3

        s1 = "babgbag";
        s2 = "bag";
        System.out.println("Output: " + numDistinct(s1, s2)); // Expected: 5
    }
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
