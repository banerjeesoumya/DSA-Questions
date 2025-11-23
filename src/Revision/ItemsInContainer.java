package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsInContainer {
    public static void main(String[] args) {
        System.out.println("=== TEST CASE 1 ===");
        String s1 = "|**|*|*";
        System.out.println(numberOfItems(s1,
                Arrays.asList(1, 1),
                Arrays.asList(5, 6)));   // Expected [2, 3]


        System.out.println("=== TEST CASE 2 (No stars) ===");
        String s2 = "|||||";
        System.out.println(numberOfItems(s2,
                Arrays.asList(1),
                Arrays.asList(5)));       // Expected [0]


        System.out.println("=== TEST CASE 3 (No pipes) ===");
        String s3 = "******";
        System.out.println(numberOfItems(s3,
                Arrays.asList(1),
                Arrays.asList(6)));       // Expected [0]


        System.out.println("=== TEST CASE 4 (Only one pipe) ===");
        String s4 = "*|***";
        System.out.println(numberOfItems(s4,
                Arrays.asList(1, 2),
                Arrays.asList(5, 4)));    // Expected [0, 0]


        System.out.println("=== TEST CASE 5 (Pipes but zero stars inside) ===");
        String s5 = "| || |";
        System.out.println(numberOfItems(s5,
                Arrays.asList(1),
                Arrays.asList(6)));       // Expected [0]


        System.out.println("=== TEST CASE 6 (Stars outside pipes) ===");
        String s6 = "*|**|*";
        System.out.println(numberOfItems(s6,
                Arrays.asList(1, 2),
                Arrays.asList(6, 5)));    // Expected [2, 2]


        System.out.println("=== TEST CASE 7 (Multiple containers) ===");
        String s7 = "|*|**|*|";
        System.out.println(numberOfItems(s7,
                Arrays.asList(1, 1, 4),
                Arrays.asList(8, 3, 7))); // Expected [3, 1, 2]


        System.out.println("=== TEST CASE 8 (Single index queries) ===");
        String s8 = "|*|";
        System.out.println(numberOfItems(s8,
                Arrays.asList(2, 1),
                Arrays.asList(2, 1)));    // Expected [0, 0]


        System.out.println("=== TEST CASE 9 (Query in star-only region) ===");
        String s9 = "|***|**|";
        System.out.println(numberOfItems(s9,
                Arrays.asList(2),
                Arrays.asList(4)));       // Expected [0]


        System.out.println("=== TEST CASE 10 (Right pipe outside range) ===");
        String s10 = "|**|***|";
        System.out.println(numberOfItems(s10,
                Arrays.asList(3),
                Arrays.asList(7)));       // Expected [1]


        System.out.println("=== TEST CASE 11 (Left pipe outside range) ===");
        String s11 = "|*|**|";
        System.out.println(numberOfItems(s11,
                Arrays.asList(1),
                Arrays.asList(4)));       // Expected [1]


        System.out.println("=== TEST CASE 12 (Single char pipe) ===");
        String s12 = "|";
        System.out.println(numberOfItems(s12,
                Arrays.asList(1),
                Arrays.asList(1)));       // Expected [0]


        System.out.println("=== TEST CASE 13 (Single char star) ===");
        String s13 = "*";
        System.out.println(numberOfItems(s13,
                Arrays.asList(1),
                Arrays.asList(1)));       // Expected [0]


        System.out.println("=== TEST CASE 14 (Overlapping queries) ===");
        String s14 = "|*|*|**|*|";
        System.out.println(numberOfItems(s14,
                Arrays.asList(1, 2, 5),
                Arrays.asList(4, 7, 9))); // Expected [2, 2, 1]


        System.out.println("=== TEST CASE 15 (Only one pipe inside each query) ===");
        String s15 = "*|***|*";
        System.out.println(numberOfItems(s15,
                Arrays.asList(1, 4),
                Arrays.asList(3, 7)));    // Expected [0, 0]


        System.out.println("=== TEST CASE 16 (Large combined test) ===");
        String s16 = "|*|*|**|*|*";
        System.out.println(numberOfItems(s16,
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(12, 10, 9, 8, 11))); // Expected [5,4,4,2,3]
    }
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();

        // 1. Precompute star counts (Prefix Sum)
        // mem[i] = total stars found in s[0...i-1]
        int[] starCount = new int[n + 1];
        for (int i = 0; i < n; i++) {
            starCount[i + 1] = starCount[i] + (s.charAt(i) == '*' ? 1 : 0);
        }

        // 2. Precompute nearest LEFT pipe
        // leftPipe[i] = index of nearest '|' at or to the left of i. -1 if none.
        int[] leftPipe = new int[n];
        int lastPipe = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lastPipe = i;
            }
            leftPipe[i] = lastPipe;
        }

        // 3. Precompute nearest RIGHT pipe
        // rightPipe[i] = index of nearest '|' at or to the right of i. -1 if none.
        int[] rightPipe = new int[n];
        lastPipe = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastPipe = i;
            }
            rightPipe[i] = lastPipe;
        }

        // 4. Process Queries
        for (int i = 0; i < startIndices.size(); i++) {
            // Convert 1-based index (Amazon input) to 0-based
            int start = startIndices.get(i) - 1;
            int end = endIndices.get(i) - 1;

            // Find valid container boundaries
            // The valid container starts at the first pipe >= start
            // The valid container ends at the first pipe <= end
            int validStartPipe = rightPipe[start];
            int validEndPipe = leftPipe[end];

            // Check if valid pipes exist and are in correct order (start < end)
            if (validStartPipe != -1 && validEndPipe != -1 && validStartPipe < validEndPipe) {
                // Calculate stars between these two pipes
                int count = starCount[validEndPipe] - starCount[validStartPipe];
                result.add(count);
            } else {
                result.add(0);
            }
        }

        return result;
    }
}
