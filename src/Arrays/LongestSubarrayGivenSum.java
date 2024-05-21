package Arrays;

public class LongestSubarrayGivenSum {
    public static void main(String[] args) {
        int[] arr ={-1, 2, 3};
        int length = lenOfLongSubarray(arr, 15);
        System.out.println(length);
    }

    public static int lenOfLongSubarray(int[] arr, int m) {
        int start = 0, end = 0, sum = arr[0], len = 0 ;
        while (end < arr.length) {
            while ((start <= end) && (sum > m)) {
                sum = sum - arr[start];
                start ++;
            }
            if (sum == m) {
                len = Math.max(len, end - start + 1);
            }
            end ++;
            if (end < arr.length)
                sum += arr[end];
        }
        return len;
    }
}
