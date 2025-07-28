package Basics;

public class Palindrome {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(int x) {
        int t = x, d, rev = 0;
        while (t > 0) {
            d = t % 10;
            t = t / 10;
            rev = rev * 10 + d;
        }
        if (rev == x) return true;
        return false;
    }
}
