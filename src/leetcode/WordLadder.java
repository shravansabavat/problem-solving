package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return level + 1;
                }
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] arr = currentWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;
                        String newString = new String(arr);
                        if (!newString.equals(currentWord) && wordList.contains(newString)) {
                            queue.add(newString);
                            wordList.remove(newString);
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        return null;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength("hit", "cog", new HashSet<>(wordList)));
    }
}
