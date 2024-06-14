package Arrays;
 import java.util.*;
public class NextPermutation {
    public static void main(String[] args) {
        int [] arr = {1,1,5};
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr);
//        reverse(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, (index + 1), nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public static void swap (int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
