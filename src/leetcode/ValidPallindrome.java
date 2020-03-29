package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidPallindrome {
    public static boolean isPalindrome1(String s) {
        if (s.isEmpty()) return true;
        char[] letters = String.join("", s.split(" ")).toCharArray();
        Map<Character, Integer> countOfLetters = new HashMap<>();
        for (char ch : letters) {
            Integer count = countOfLetters.get(ch);
            if (count == null) {
                count = 0;
            }
            countOfLetters.put(ch, count + 1);
        }

        boolean foundOddAlready = false;
        for (Map.Entry<Character, Integer> entry : countOfLetters.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value % 2 != 0 && !foundOddAlready) {
                foundOddAlready = true;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        String alphanumOnlty= s.replaceAll("[^a-zA-Z0-9]", "");
        char[] letters = String.join("", alphanumOnlty.split(" ")).toCharArray();
        StringBuilder sb = new StringBuilder(new String(letters));
        String actualWithoutSpaces = new String(letters);
        return sb.reverse().toString().equalsIgnoreCase(actualWithoutSpaces);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
