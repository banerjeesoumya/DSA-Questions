package Arrays;

import java.util.HashMap;

public class LongestSubarrayGivenSum {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int length = lenOfLongSubarray(arr, 3);
        System.out.println(length);
    }

    public static int lenOfLongSubarray(int[] arr, int m) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, len = 0;
        int remSum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum == m) {
                len = Math.max(len, i + 1);
            }
            remSum = sum - m;

            if (map.containsKey(remSum)) {
                int val = map.get(remSum);
                len = Math.max(len, i - val);
//                map.put(remSum, i + 1);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
}


















































//        int start = 0, end = 0, sum = arr[0], len = 0 ;
//        while (end < arr.length) {
//            while ((start <= end) && (sum > m)) {
//                sum = sum - arr[start];
//                start ++;
//            }
//            if (sum == m) {
//                len = Math.max(len, end - start + 1);
//            }
//            end ++;
//            if (end < arr.length)
//                sum += arr[end];
//        }
//        return len;