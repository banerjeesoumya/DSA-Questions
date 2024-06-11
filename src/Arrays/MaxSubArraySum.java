package Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int returned = maxSubArray(arr);
        System.out.println(returned);
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0, maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
