package leetcode.thirtyday;

import java.util.Stack;

public class Day9BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        return clean(S).equals(clean(T));
    }

    private static String clean(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char ch : arr) {
            if (stack.isEmpty() && ch != '#') {
                stack.push(ch);
            } else if (ch != '#') {
                stack.push(ch);
            } else if (!stack.isEmpty()){
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
    }
}

