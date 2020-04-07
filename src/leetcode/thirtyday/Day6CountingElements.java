package leetcode.thirtyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6CountingElements {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> anagramTracker = new HashMap<>();
        for (String str : strs) {
            int id = getID(str);
            List<String> anagramList = anagramTracker.get(id);
            if (anagramList == null) {
                anagramList = new ArrayList<>();
                anagramTracker.put(id, anagramList);
            }
            anagramList.add(str);
        }

        return new ArrayList<>(anagramTracker.values());
    }

    public static int getID(String s){
        int counter = 0;
        for(char ch : s.toCharArray()){
            counter += ch;
        }
        return Integer.hashCode(counter);
    }

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(words));
    }
}
