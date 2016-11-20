package uottawa.coding;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    
    public static List<String> getPermutations1(String str) {
        if (str == null) {
            return null;
        }
        List<String> permutations = new ArrayList<String>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        
        char first = str.charAt(0);
        List<String> words = getPermutations1(str.substring(1));
        
        for (String word : words) {
            for (int index = 0; index <= word.length(); index++) {
                String possibleWord = insertCharAt(word, first, index);
                permutations.add(possibleWord);
            }
        }
        
        return permutations;
    }
    
    public static List<String> getPermutations2(String str) {
        if (str == null) {
            return null;
        }
        List<String> permutations = new ArrayList<String>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        
        for (int index = 0; index < str.length(); index++) {
            String before = str.substring(0, index);
            String after = str.substring(index + 1, str.length());
            
            List<String> perms = getPermutations2(before + after);
            
            for (String word : perms) {
                permutations.add(str.charAt(index) + word);
            }
            
        }
        return permutations;
    }

    private static String insertCharAt(String word, char first, int index) {
        String start = word.substring(0, index);
        String end = word.substring(index);
        
        return start + first + end;
    }

    public static void main(String[] args) {
        System.out.println(getPermutations2("abc"));
    }
}
