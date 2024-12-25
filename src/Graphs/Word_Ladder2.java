package Graphs;

import java.util.*;

public class Word_Ladder2 {
    public static void main(String[] args) {

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Put the words in a set
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
//        The queue has to store the sequence
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> current = new ArrayList<>();
        current.add(beginWord);
        queue.add(current);
//       Now we also need an arraylist which will store the words that are being used at every level
        ArrayList<String> usedOnLevel = new ArrayList<String>();
//        The first one to be initially stored is the beginWord that is gonna be used
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<String> curr = queue.peek();
            queue.remove();
//            Remove all the words that has been used in the previous levels to transform
            if (curr.size() > level) {
                level ++;
                for (String word : usedOnLevel) {
                    set.remove(word);
                }
            }
//            Now we will take the word that has been taken out of the queue
//            and we will transform it with all possible changes and check if it exists
//            in the wordList
            String word = curr.get(curr.size() - 1);
            if (word.equals(endWord)) {
                if (result.size() == 0) {
                    result.add(curr);
                }
                else if (result.get(0).size() == curr.size()) {
                    result.add(curr);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] original = word.toCharArray();
                    original[i] = c;
                    String newWord = new String(original);
                    if (set.contains(newWord)) {
                        curr.add(newWord);
                        ArrayList<String> temp = new ArrayList<>(curr);
                        queue.add(temp);
                        usedOnLevel.add(newWord);
//                        We need to remove this for the next word to come over
//                        here that would lead to another possible sequence
                        curr.remove(curr.size() - 1);
                    }
                }
            }
        }
        return result;
    }
}
