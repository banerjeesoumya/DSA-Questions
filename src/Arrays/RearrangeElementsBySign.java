package Arrays;

import java.util.Arrays;

public class RearrangeElementsBySign {
    public static void main(String[] args) {
        int[] arr = {-1,1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(rearrange(arr)));
    }

    public static int[] rearrange(int[] nums) {
        int[] arr = new int[nums.length];
        int even = 0, odd = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                arr[even] = nums[i];
                even = even + 2;
            } else {
                arr[odd] = nums[i];
                odd = odd + 2;
            }
        }
        return arr;
    }
}
