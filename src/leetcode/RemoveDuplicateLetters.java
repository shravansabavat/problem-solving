package leetcode;

import java.io.CharArrayReader;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s)
    {
        char[] array = s.toCharArray();
        int[] frequency = new int[26];
        for (char c : array){
            frequency[c - 'a'] += 1;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] onStack = new boolean[26];

        for (char c : array) {
            if (onStack[c - 'a']) {
                frequency[c - 'a'] -= 1;
                continue;
            }

            while (!stack.isEmpty() && frequency[stack.peek() - 'a'] > 0 && stack.peek() > c) {
                onStack[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            onStack[c - 'a'] = true;
            frequency[c - 'a'] -= 1;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        //System.out.println(removeDuplicateLetters(s));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
