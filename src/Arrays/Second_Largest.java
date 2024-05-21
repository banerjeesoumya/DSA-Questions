/*
Given an array Arr of size N, print the second largest distinct element from an array. If the second largest element doesn't exist then return -1.
 */

// APPROACH: Initialize two variables largest and second largest to -1
//           Traverse the entire array, and when the current element is > than the largest initialize to second largest to largest and largest to the current element
//           else when the current element id > second largest and != largest then initialize second largest to the current element;

package Arrays;

public class Second_Largest {
    public static void main(String[] args) {
//        int[] arr = {61, 30, 28, 47, 42, 25, 41, 56, 27, 45, 44, 34, 46, 35, 58, 36, 60, 29, 53, 55, 32, 31, 33, 59, 50, 51, 52, 37, 39, 38, 43, 49, 54, 57, 40, 26, 48};
        int[] arr = {242, 242, 242, 242, 242, 242, 242, 242, 242, 242, 242, 242};
        int second_largest = secondLargest(arr);
        System.out.println(second_largest);
    }

    private static int secondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;
        for (int  i = 0 ; i < arr.length; i ++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
