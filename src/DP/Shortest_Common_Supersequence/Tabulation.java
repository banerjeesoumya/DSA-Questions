package DP.Shortest_Common_Supersequence;

public class Tabulation {
    public static void main(String[] args) {
        // Test case 1
        String text1 = "abac";
        String text2 = "cab";
        String result1 = shortestCommonSupersequence(text1, text2);
        System.out.println("SCS of \"" + text1 + "\" and \"" + text2 + "\" is: " + result1);

        // Test case 2
        String text3 = "geek";
        String text4 = "eke";
        String result2 = shortestCommonSupersequence(text3, text4);
        System.out.println("SCS of \"" + text3 + "\" and \"" + text4 + "\" is: " + result2);

        // Test case 3 (edge case: one string empty)
        String text5 = "";
        String text6 = "abc";
        String result3 = shortestCommonSupersequence(text5, text6);
        System.out.println("SCS of \"" + text5 + "\" and \"" + text6 + "\" is: " + result3);

    }
    public static String shortestCommonSupersequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
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
        String ans = "";
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans = ans + text1.charAt(i - 1);
                i --;
                j --;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans = ans + text1.charAt(i - 1);
                i --;
            } else {
                ans = ans + text2.charAt(j - 1);
                j --;
            }
        }
        while (i > 0) {
            ans = ans + text1.charAt(i - 1);
            i --;
        }
        while (j > 0) {
            ans = ans + text2.charAt(j - 1);
            j --;
        }
        return new StringBuilder(ans).reverse().toString();
    }
}
