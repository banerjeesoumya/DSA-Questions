package Revision;

public class Game_Simulation {
    public static void main(String[] args) {
        String[] tests = {
                "",             // 1. empty string (edge case)
                "a",            // 2. single character
                "aa",           // 3. identical characters
                "ab",           // 4. two characters increasing
                "ba",           // 5. two characters decreasing
                "cat",          // 6. small random
                "bdac",         // 7. mixed order
                "zzz",          // 8. all same letters
                "abc",          // 9. already sorted lexicographically
                "cba",          // 10. reverse sorted
                "azbz",         // 11. repeating pattern
                "qwerty",       // 12. random 6-letter
                "leetcode",     // 13. real word
                "helloworld",   // 14. longer string
                "abababab",     // 15. repeating alternating
                "zyxwvuts",     // 16. strictly decreasing long
                "mnopqrst",     // 17. strictly increasing long
                "bca",          // 18. tricky lexicographical
                "zabc",         // 19. bigger letter then small
                "aaaabbbb",     // 20. grouped duplicates
        };

        for (String test : tests) {
            try {
                if (test.isEmpty()) {
                    System.out.println("Input: \"\"  →  Output: [ERROR: EMPTY STRING]");
                } else {
                    System.out.println("Input: \"" + test + "\"  →  Final Character: " + finalCharacter(test));
                }
            } catch (Exception e) {
                System.out.println("Input: \"" + test + "\"  →  Exception: " + e.getMessage());
            }
        }
    }

    public static char finalCharacter(String s) {
        StringBuilder currentString = new StringBuilder(s);
        int turn = 1;
        while (currentString.length() > 1) {
            String bestResult = "";
            if (turn % 2 != 0) {
                bestResult = "~";
                for (int i = 0; i < currentString.length(); i ++) {
                    String resultString = currentString.substring(0, i) + currentString.substring(i + 1);

                    if (resultString.compareTo(bestResult) < 0) {
                        bestResult = resultString;
                    }
                }
            } else {
                bestResult = "";
                for (int i = 0; i < currentString.length(); i ++) {
                    String resultString = currentString.substring(0, i) + currentString.substring(i + 1);
                    if (resultString.compareTo(bestResult) > 0) {
                        bestResult = resultString;
                    }
                }
            }
            currentString = new StringBuilder(bestResult);
            turn ++;
        }
        return currentString.charAt(0);
    }
}
