package Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Balanced_Segments {

    public static void main(String[] args) {
        Balanced_Segments bs = new Balanced_Segments();

        // Helper for pretty printing
        java.util.function.BiConsumer<String, List<Integer>> test = (name, arr) -> {
            long result = bs.countBalancedSegments(arr);
            System.out.println(name + " | Input: " + arr + " → Output: " + result);
        };

        System.out.println("===== RUNNING TEST CASES =====");

        test.accept("Test 1  (all equal)", List.of(1, 1, 1));                // Expected 1
        test.accept("Test 2  (no pairs)", List.of(2, 1, 2));                 // Expected 0
        test.accept("Test 3  (center 1s)", List.of(3, 1, 1, 1, 3));          // Expected 1
        test.accept("Test 4  (wrong sums)", List.of(5, 2, 2, 2, 5));         // Expected 0
        test.accept("Test 5  (multiple pairs)", List.of(2, 2, 2, 2));        // Expected 2
        test.accept("Test 6  (empty)", List.of());                           // Expected 0
        test.accept("Test 7  (single)", List.of(10));                        // Expected 0
        test.accept("Test 8  (negatives)", List.of(3, -1, -1, 3));           // Expected 0
        test.accept("Test 9  (negative match)", List.of(-2, 1, 1, -2));      // Expected 0
        test.accept("Test 10 (mixed)", List.of(1, 2, 1, 2, 1, 2, 1));        // Expected 0
        test.accept("Test 11 (sum inside)", List.of(4, 1, 3, 4));            // Expected 1

        System.out.println("===== END TESTS =====");
    }

    public long countBalancedSegments(List<Integer> capacity) {
        int n = capacity.size();

        // Correct prefix-sum array (long for safety)
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + capacity.get(i);
        }

        // Map: value -> all indices where it appears
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(capacity.get(i), k -> new ArrayList<>()).add(i);
        }

        long count = 0;

        // For each distinct value
        for (int key : map.keySet()) {
            List<Integer> indices = map.get(key);

            // Check all pairs of indices for this value
            for (int i = 0; i < indices.size(); i++) {
                for (int j = i + 1; j < indices.size(); j++) {

                    int left = indices.get(i);
                    int right = indices.get(j);

                    // Correct prefix-sum subarray formula:
                    // sum(left+1 .. right-1) = prefix[right] - prefix[left+1]
                    long subSum = prefix[right] - prefix[left + 1];

                    if (subSum == key) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
