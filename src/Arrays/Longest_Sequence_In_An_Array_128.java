package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Longest_Sequence_In_An_Array_128 {
    public static void main(String[] args) {
        int [] arr = {};
        int l = longestConsecutive(arr);
        System.out.println(l);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longest = 0;
        for (int el : set) {
            if (!set.contains(el - 1)) {
                int count = 1;
                int x = el;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    count ++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
















//        Arrays.sort(nums);
//        int lastSmall = Integer.MIN_VALUE;
//        int longest = 1;
//        int curr = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if ((nums[i] - 1) == lastSmall) {
//                lastSmall = nums[i];
//                curr ++;
//            }
//            if (nums[i] != lastSmall) {
//                curr = 1;
//                lastSmall = nums[i];
//            }
//            longest = Math.max(longest, curr);
//        }
//        return longest;
    }
}
