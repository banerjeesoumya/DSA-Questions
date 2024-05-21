/*
Given an array nums, return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that
A[i] == B[(i+x) % A.length], where % is the modulo operation.
 */

package Arrays;

public class Rotated_Sorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean check = rotatedSorted(arr);
        System.out.println(check);
    }

    private static boolean rotatedSorted(int[] arr) {
        int c = 0;
        for (int i = 1; i < arr.length; i ++) {
            if (arr[i] < arr[i - 1]){
                c ++;
            }
        }

        if (arr[arr.length - 1] > arr[0]){
            c ++;
        }

        if (c > 1)
            return false;
        return true;
    }
}
