package Arrays;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int max = majorityElement(arr);
        System.out.println(max);
    }

    public static int majorityElement(int[] nums) {

//        Optimal Approach (Time Complexity - O(n) Space Complexity - O(1))
        int count = 0;
        int el = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count ++;
                el = nums[i];
            } else if (nums[i] == el) {
                count ++;
            } else {
                count --;
            }
        }
        return el;

//        Better Solution (Time Complexity - O(N) + O(NlogN), Space Complexity - O(1))
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int val = map.getOrDefault(nums[i], 0);
//            map.put(nums[i], val + 1);
//        }
//        for (Integer key : map.keySet()) {
//            if (map.get(key) > nums.length / 2) {
//                return key;
//            }
//        }
//        return -1;
    }
}
