package Graphs;

import java.util.*;

public class Word_Ladder1 {
    public static void main(String[] args) {
        Word_Ladder1 solution = new Word_Ladder1();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println("The length of the shortest transformation sequence is: " + result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<WordLengthPair> q = new LinkedList<>();
        q.add(new WordLengthPair(beginWord, 1));
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek().word;
            int length = q.peek().length;
            q.remove();
            if (word.equals(endWord)) {
                return length;
            }
            for (int i = 0; i < word.length(); i ++) {
                char[] original = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j ++) {
                    original[i] = j;
                    String newWord = new String(original);
                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.add(new WordLengthPair(newWord, length + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class WordLengthPair {
    String word;
    int length;

    public WordLengthPair(String word, int length) {
        this.word = word;
        this.length = length;
    }
}