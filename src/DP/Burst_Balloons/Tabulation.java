package DP.Burst_Balloons;

import java.util.ArrayList;
import java.util.Arrays;

public class Tabulation {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        int result = maxCoins(nums);
        System.out.println("Maximum coins you can collect: " + result);
    }
    public static int maxCoins(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 1);
        for (int num : nums) {
            list.add(num);
        }
        list.add(1);
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int[] rows : dp) {
            Arrays.fill(rows, 0);
        }
        for (int i = nums.length; i >= 1; i --){
            for (int j = 1; j <= nums.length; j ++) {
                if (i > j) continue;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k ++) {
                   int coins = list.get(i - 1) * list.get(k) * list.get(j + 1) + dp[i][k - 1] + dp[k + 1][j];
                   max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][nums.length];
    }

}
