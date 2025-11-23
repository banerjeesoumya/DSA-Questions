package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Maximum_Network {
    public static void main(String[] args) {
        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(2, 4, 3, 1, 2),      // expected: 5
                Arrays.asList(1, 2, 1, 2),          // expected: 3
                Arrays.asList(1, 2, 1),             // expected: 1
                Arrays.asList(5, 5, 5, 5),          // all equal, expected: 10 (choose any 2 primaries)
                Arrays.asList(1, 1, 1, 1, 1, 1),    // all equal, expected: 3
                Arrays.asList(10, 20),              // minimal n=2, expected: 10
                Arrays.asList(9, 8, 7, 6, 5, 4),    // descending, expected: 18 (sum of 6,5,4)
                Arrays.asList(1, 100, 2, 99, 3, 98),// zig-zag big-small, expected: 6 (3+2+1)
                Arrays.asList(4, 4, 4),             // odd count, expected: 4
                Arrays.asList(1, 50, 2, 49, 3, 48), // alternating, expected: 6
                Arrays.asList(1, 100, 1000, 5, 6),  // odd, expected: 6 (1 valid primary)
                Arrays.asList(2, 2),                // minimal pair, expected: 2
                Arrays.asList(3, 1, 2, 4),          // mixed, expected: 4
                Arrays.asList(100, 1, 2, 3, 4, 5),  // one big outlier, expected: 6 (1+2+3)
                Arrays.asList(1, 2, 100, 200, 3, 4) // two big backups, expected: 6 (3+2+1)
        );

        int index = 1;
        for (List<Integer> testCase : testCases) {
            long result = maximum_network(new ArrayList<>(testCase));
            System.out.println("Test Case " + index + ": " + testCase +
                    "  --> Output: " + result);
            index++;
        }
    }

    public static long maximum_network(List<Integer> memory) {
        // Step 1: Sort the memory list in descending order.
        // This allows us to process the largest capacities first.
        Collections.sort(memory, Collections.reverseOrder());

        long maxCapacitySum = 0;
        int availableBackups = 0;

        // We need to form exactly n/2 pairs (where n is the effective number of servers used)
        // The problem implies we use floor(size / 2) pairs.
//        int pairsNeeded = memory.size() / 2;

        for (int mem : memory) {
            // If we have formed all necessary pairs, we can stop
//            if (pairsNeeded == 0) {
//                break;
//            }

            // Step 2: Greedy Decision
            if (availableBackups > 0) {
                // If we have a backup available, it is guaranteed to be >= current 'mem'
                // (because we sorted descending).
                // We designate the current server as PRIMARY to add to our score.
                maxCapacitySum += mem;

                // Use up one backup
                availableBackups--;

                // One pair successfully created
//                pairsNeeded--;
            } else {
                // If no backups are available, this server represents a high capacity
                // that must serve as a BACKUP for a future, smaller server.
                availableBackups++;
            }
        }

        return maxCapacitySum;
    }
}
