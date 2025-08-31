package DP.Partition_Equal_Subset_Sum;

public class Tabulation {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        boolean result = canPartition(arr);
        System.out.println("Can partition: " + result);
    }
    public static boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
        dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (j > arr[i]) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = notTake || take;
            }
        }
        return dp[n - 1][target];
    }
}
