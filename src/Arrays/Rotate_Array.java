package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        arr = rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] rotate(int[] arr, int k) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[(i + k) % arr.length] = arr[i];
        }
        return temp;
    }
}
