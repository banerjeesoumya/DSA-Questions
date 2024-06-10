package Arrays;

import java.util.Arrays;

public class Sort_0_1_2 {
    public static void main(String[] args) {
        int[] arr = {2,0,1};
        System.out.println(Arrays.toString(arr));
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0 , high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low ++;
                mid ++;
            } else if (nums[mid] == 1) {
                mid ++;
            } else {
                swap(nums, mid, high);
                high --;
            }
        }
    }
    public static void swap (int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
