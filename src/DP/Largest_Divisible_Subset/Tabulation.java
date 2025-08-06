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
        int[] nums2 = {1, 2, 4, 8};
        List<Integer> result2 = largestDivisibleSubset(nums2);
        System.out.println("Example 2 Output: " + result2);

    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);  // Initially, every element is a subset of size 1
        int maxLen = 1;  // Length of the largest divisible subset
        int maxIdx = 0;  // Index of the last element in the largest divisible subset

        // Compute dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        // Reconstruct the largest divisible subset
        List<Integer> ans = new ArrayList<>();
        int k = maxIdx;
        while (dp[k] > 1) {
            ans.add(nums[k]);
            k = hash[k];
        }
        ans.add(nums[k]);

        Collections.reverse(ans);
        return ans;
    }
}
