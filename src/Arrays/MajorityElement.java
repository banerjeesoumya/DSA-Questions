package Arrays;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        int max = majorityElement(arr);
        System.out.println(max);
    }

    public static int majorityElement(int[] nums) {

//        Better Solution
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
