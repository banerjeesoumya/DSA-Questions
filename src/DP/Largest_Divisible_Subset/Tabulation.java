package DP.Largest_Divisible_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tabulation {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        List<Integer> result1 = largestDivisibleSubset(nums1);
        System.out.println("Example 1 Output: " + result1);

        // Example 2
        int[] nums2 = {5, 4, 11, 1, 16, 8};
        List<Integer> result2 = largestDivisibleSubset(nums2);
        System.out.println("Example 2 Output: " + result2);

    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int max = 1;
        int lastInd = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev_ind = 0; prev_ind < i; prev_ind ++) {
                if ((nums[i] % nums[prev_ind] == 0) && (dp[i] < 1 + dp[prev_ind])) {
                    dp[i] = 1 + dp[prev_ind];
                    hash[i] = prev_ind;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastInd = i;
            }
        }
        List<Integer> temp = new ArrayList<>();
        int k = lastInd;
        temp.add(nums[k]);
        while (hash[k] != k) {
            k = hash[k];
            temp.add(nums[k]);
        }
        Collections.reverse(temp);
        return temp;
    }
}
