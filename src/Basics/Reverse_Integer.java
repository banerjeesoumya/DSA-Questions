package Basics;

public class Reverse_Integer {
    public static void main(String[] args) {
        int[] testCases = {123, -123, 120};
        for (int x : testCases) {
            int result = reverse(x);
            System.out.println("Input: " + x + " | Output: " + result);
        }

    }
    public static int reverse (int x) {
        int d, t = Math.abs(x);
        long rev = 0;
        while (t > 0) {
            d = t % 10;
            t = t / 10;
            rev = rev * 10 + d;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        return (x < 0) ? -(int)rev : (int)rev;
    }
}
