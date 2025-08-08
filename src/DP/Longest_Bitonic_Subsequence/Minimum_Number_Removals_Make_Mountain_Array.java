package DP.Longest_Bitonic_Subsequence;

import java.util.Arrays;

public class Minimum_Number_Removals_Make_Mountain_Array {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 1};
        int[] nums2 = {2, 1, 1, 5, 6, 2, 3, 1};

        System.out.println("Example 1 Output: " + minimumMountainRemovals(nums1)); // Expected: 0
        System.out.println("Example 2 Output: " + minimumMountainRemovals(nums2)); // Expected: 3
    }
    public static int minimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for (int i = 0; i < n; i++) {
            for (int prev_ind = 0; prev_ind < i; prev_ind++) {
                if ((arr[prev_ind] < arr[i]) && (1 + dp1[prev_ind] > dp1[i])) {
                    dp1[i] = 1 + dp1[prev_ind];
                }
            }
        }
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int prev_ind = n - 1; prev_ind > i; prev_ind--) {
                if ((arr[prev_ind] < arr[i]) && (1 + dp2[prev_ind] > dp2[i])) {
                    dp2[i] = 1 + dp2[prev_ind];
                }
            }
            max = Math.max(max, dp2[i] + dp1[i] - 1);
        }
        return n - max;
    }
}
