package DP;

import java.util.Arrays;

public class Intro {
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibo(n, dp));
    }

    public static int fibo (int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
    }
}
