package DP.Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintingLIS {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,2,3};
        List<Integer> lis = printLIS(arr);
        System.out.println("Longest Increasing Subsequence:");
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
    public static List<Integer> printLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int max = 1, lastInd = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev_ind = 0; prev_ind < i; prev_ind++) {
                if ((arr[prev_ind] < arr[i]) && (1 + dp[prev_ind] > dp[i])) {
                    dp[i] = 1 + dp[prev_ind];
                    hash[i] = prev_ind;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastInd = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int k = lastInd;
        res.add(arr[k]);
        while (hash[k] != k) {
            res.add(hash[k]);
            k = hash[k];
        }
        Collections.reverse(res);
        return res;
    }
}
