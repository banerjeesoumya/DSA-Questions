/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 */


package Arrays;

public class SingeNumber {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        int num = singleNumber(arr);
        System.out.println(num);
    }
    public static int singleNumber(int[] nums) {

//        Optimal solution using xor
//        Initialize a xor variable = 0, xor it to the entire array
//        Xoring the above array => xor = 0 ^ 1 ^ 1 ^ 2 ^ 3 ^ 3 ^ 4 ^ 4 => 1 ^ 1 ^ 2 ^ 3 ^ 3 ^ 4 ^ 4 = 0 ^ 2 ^ 0 ^ 0 = 2
        int xor  = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    count ++;
//                }
//            }
//            if (count == 1) {
//                return nums[i];
//            }
//            count = 0;
//        }
//        return -1;
    }
}
