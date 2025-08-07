package DP.Longest_String_Chain;

import java.util.Arrays;
import java.util.Comparator;

public class Tabulation {
    public static void main(String[] args) {
        String[] words1 = {"a", "b", "ba", "bca", "bda", "bdca"};
        int result1 = longestStringChain(words1);
        System.out.println("Example 1 Output: " + result1); // Expected: 4

        String[] words2 = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        int result2 = longestStringChain(words2);
        System.out.println("Example 2 Output: " + result2); // Expected: 5

        String[] words3 = {"a", "ab", "ac", "bd", "abc", "abd", "abdd"};
        int result3 = longestStringChain(words3);
        System.out.println("Example 3 Output: " + result3); // Expected: 4
    }
    public static Comparator<String> compare = ((s1, s2) -> s1.length() - s2.length());
    public static int longestStringChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, compare);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int prev_ind = 0; prev_ind < i; prev_ind++) {
                if (check(words[i], words[prev_ind]) && dp[i] < 1 + dp[prev_ind]) {
                    dp[i] = 1 + dp[prev_ind];
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static boolean check(String a, String b) {
        if (a.length() != b.length() + 1) {
            return false;
        }
        int first = 0, second = 0;
        while (first < a.length()) {
            if (second < b.length() && a.charAt(first) == b.charAt(second)) {
                first ++; second ++;
            } else {
                first ++;
            }
        }
        return first == a.length() && second == b.length();
    }
}
