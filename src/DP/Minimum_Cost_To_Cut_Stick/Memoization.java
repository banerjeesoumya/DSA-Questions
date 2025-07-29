package DP.Minimum_Cost_To_Cut_Stick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Memoization {
    public static void main(String[] args) {
        int n = 9;
        int[] cuts = {5, 6, 1, 4, 2};

        int result = minCosts(n, cuts);
        System.out.println("Minimum cost to cut the stick: " + result);

    }
    public static int minCosts(int n, int[]cuts) {
        ArrayList<Integer> cutsList = new ArrayList<>();
        for (int cut : cuts) {
            cutsList.add(cut);
        }
        cutsList.add(0);
        cutsList.add(n);
        Collections.sort(cutsList);
        int c = cutsList.size();
        int[][] dp = new int[c][c];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp(1, c - 2, cutsList, dp);
    }
    public static int dp(int i, int j, ArrayList<Integer> cuts, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k ++) {
            int cost = cuts.get(j + 1) - cuts.get(i - 1) + dp(i, k - 1, cuts, dp) + dp (k + 1, j, cuts, dp);
            min = Math.min(min, cost);
        }
        dp[i][j] = min;
        return min;
    }
}
