package Revision;

public class Stable_String {
    public static void main(String[] args) {
        String[] tests = {
                "", "0", "1", "00", "11", "01", "10",
                "001", "110", "010", "101", "011", "100",
                "0011", "1100", "0101", "1010",
                "000111", "111000", "000000", "111111",
                "010", "101", "0101", "1010", "01010", "10101", "0101010", "1010101",
                "1011010", "101011", "1101001", "1001110", "1010011", "01101001", "110110101",
                "00001111", "11110000", "000111000", "111000111", "0001000", "1110111",
                "0010111", "1100101", "100011011", "0111100100",
                "000000000111111111", "111111110000000000",
                "010101010101010", "101010101010101",
                "111000111000111", "000111000111000"
        };

        for (String test : tests) {
            if (test.length() == 0) {
                System.out.println("\"\" → EMPTY STRING (skip)");
                continue;
            }
            System.out.println("\"" + test + "\" → " + calculateMinimumModifications(test));
        }
    }
    public static int calculateMinimumModifications(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        // Step 1: Count total zeros and ones
        int totalZeros = 0, totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') totalZeros++;
            else totalOnes++;
        }

        // Global minimum (converting entire string to all-0 or all-1)
        int minFlips = Math.min(totalZeros, totalOnes);

        // ✔ Missing split BEFORE index 0
        // Split: | s
        int costAscendingStart = 0 + totalZeros; // left all 0, right all 1 → flip all zeros in right
        int costDescendingStart = 0 + totalOnes; // left all 1, right all 0 → flip all ones in right
        minFlips = Math.min(minFlips, Math.min(costAscendingStart, costDescendingStart));

        // Step 2: Track prefix counts
        int currentZeros = 0, currentOnes = 0;

        for (int i = 0; i < n; i++) {

            // Update prefix (left side) counts
            if (s.charAt(i) == '0') currentZeros++;
            else currentOnes++;

            // Suffix (right side) counts
            int remainingZeros = totalZeros - currentZeros;
            int remainingOnes = totalOnes - currentOnes;

            // Form 1: 000...0111...
            int costAscending = currentOnes + remainingZeros;

            // Form 2: 111...1000...
            int costDescending = currentZeros + remainingOnes;

            // Track global minimum
            minFlips = Math.min(minFlips,
                    Math.min(costAscending, costDescending));
        }

        return minFlips;
    }
}
