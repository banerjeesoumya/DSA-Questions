/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
that is missing from the array.

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number
in the range since it does not appear in nums.
 */

package Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        int missing = missingNumber(arr);
        System.out.println(missing);
    }

    private static int missingNumber(int[] arr) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor1 = xor1 ^ arr[i];
            xor2 = xor2 ^ (i + 1);
        }
        return xor1 ^ xor2;

//        ANOTHER OPTIMAL APPROACH

//        int total = ((arr.length) * (arr.length + 1)) / 2;
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//        }
//        return total - sum;
    }
}
