package Revision;

public class MoveUnits {
    public static void main(String[] args) {
        // -------------------------
        // TEST CASE 1 (Given Example)
        // -------------------------
        int[] pop1 = {0, 10, 5, 8, 9, 6};
        String u1 = "01101";
        System.out.println("Test Case 1:");
        System.out.println("Population: [10, 5, 8, 9, 6]");
        System.out.println("Units:      0 1 1 0 1");
        System.out.println("Expected: 27");
        System.out.println("Output:   " + moveUnits(pop1, u1));
        System.out.println("----------------------------------");

        // -------------------------
        // TEST CASE 2 (All cities have units)
        // -------------------------
        int[] pop2 = {0, 3, 4, 5, 6};
        String u2 = "1111";
        // best: protect all → sum = 3+4+5+6 = 18
        System.out.println("Test Case 2:");
        System.out.println("Population: [3, 4, 5, 6]");
        System.out.println("Units:      1 1 1 1");
        System.out.println("Expected: 18");
        System.out.println("Output:   " + moveUnits(pop2, u2));
        System.out.println("----------------------------------");

        // -------------------------
        // TEST CASE 3 (No units at all)
        // -------------------------
        int[] pop3 = {0, 7, 8, 9};
        String u3 = "000";
        // no protection → 0
        System.out.println("Test Case 3:");
        System.out.println("Population: [7, 8, 9]");
        System.out.println("Units:      0 0 0");
        System.out.println("Expected: 0");
        System.out.println("Output:   " + moveUnits(pop3, u3));
        System.out.println("----------------------------------");

        // -------------------------
        // TEST CASE 4 (Units only at the end)
        // -------------------------
        int[] pop4 = {0, 5, 10, 15};
        String u4 = "001";
        // Only city3 has a unit:
        // city3 can protect city3, OR move to protect city2.
        // Best: protect city3 → 15
        System.out.println("Test Case 4:");
        System.out.println("Population: [5, 10, 15]");
        System.out.println("Units:      0 0 1");
        System.out.println("Expected: 15");
        System.out.println("Output:   " + moveUnits(pop4, u4));
        System.out.println("----------------------------------");

        // -------------------------
        // TEST CASE 5 (Alternate pattern)
        // -------------------------
        int[] pop5 = {0, 4, 9, 2, 7, 6};
        String u5 = "10101";
        // Unit positions: 1,3,5
        // Optimal logic should select the best pulls.
        System.out.println("Test Case 5:");
        System.out.println("Population: [4, 9, 2, 7, 6]");
        System.out.println("Units:      1 0 1 0 1");
        System.out.println("Output:   " + moveUnits(pop5, u5));
        System.out.println("----------------------------------");

        // -------------------------
        // TEST CASE 6 (Big values)
        // -------------------------
        int[] pop6 = {0, 100, 200, 300, 400};
        String u6 = "1101";
        System.out.println("Test Case 6:");
        System.out.println("Population: [100, 200, 300, 400]");
        System.out.println("Units:      1 1 0 1");
        System.out.println("Output:   " + moveUnits(pop6, u6));
        System.out.println("----------------------------------");
    }
    public static long moveUnits(int[] population, String unit) {
        int n = population.length - 1;   // population is 1-based, index 1..n

        long dp0; // did NOT pull from next city
        long dp1; // DID pull from next city

        // ----- Base Case: City 1 -----
        if (unit.charAt(1 - 1) == '1') {   // charAt uses 0-based
            dp0 = population[1];
        } else {
            dp0 = 0;
        }

        if (n >= 2 && unit.charAt(2 - 1) == '1') {
            dp1 = population[1];
        } else {
            dp1 = Long.MIN_VALUE / 4; // impossible state
        }

        // ----- DP from city 2 to n -----
        for (int i = 2; i <= n; i++) {
            long prev0 = dp0;
            long prev1 = dp1;

            // ----- Compute new dp0 -----
            long valWithOwnUnit;
            if (unit.charAt(i - 1) == '1') {
                valWithOwnUnit = prev0 + population[i];
            } else {
                valWithOwnUnit = prev0;
            }

            long valWithoutUnit = prev1;

            long newDp0 = Math.max(valWithOwnUnit, valWithoutUnit);

            // ----- Compute new dp1 -----
            long newDp1;
            if (i < n && unit.charAt(i + 1 - 1) == '1') {
                newDp1 = Math.max(prev0, prev1) + population[i];
            } else {
                newDp1 = Long.MIN_VALUE / 4;
            }

            dp0 = newDp0;
            dp1 = newDp1;
        }

        // final result is dp0
        return dp0;
    }
}
