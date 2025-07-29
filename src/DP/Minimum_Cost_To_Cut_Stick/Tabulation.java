package DP.Minimum_Cost_To_Cut_Stick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Tabulation {
    public static void main(String[] args) {
        int n = 9;
        int[] cuts = {5, 6, 1, 4, 2};

        int result = minCosts(n, cuts);
        System.out.println("Minimum cost to cut the stick: " + result);
    }
    public static int minCosts(int n, int[] cuts) {
        ArrayList<Integer> cutsList = new ArrayList<>();
        for (int cut : cuts) {
            cutsList.add(cut);
        }
        cutsList.add(0); cutsList.add(n);
        Collections.sort(cutsList);
        int c = cuts.length;
        int[][] dp = new int[c + 2][c + 2];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        for (int i = c; i >= 1; i --) {
            for (int j = 1; j <= c; j ++) {
                if (i > j) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k ++) {
                    int cost = cutsList.get(j + 1) - cutsList.get(i - 1) + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }
}
