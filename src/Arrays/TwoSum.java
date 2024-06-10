package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int [] arr = {2, 6, 5 ,8, 11};
        System.out.println(Arrays.toString(twoSum(arr, 14)));
    }

    public static int[] twoSum(int[] nums, int target) {

//        Hashmap Approach [Time Complexity - O(n) & Space Complexity - O(n)]
        int remSum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            remSum = target - nums[i];
            if (map.containsKey(remSum)) {
                return new int[]{map.get(remSum), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
