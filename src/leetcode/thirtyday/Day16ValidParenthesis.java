package leetcode.thirtyday;

import java.util.Stack;

public class Day16ValidParenthesis {

    public static boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    public static boolean checkValidString1(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> regex = new Stack<>();

        char[] arr = s.toCharArray();
        for(int index = 0; index < arr.length; index++) {
            if (arr[index] == '(') {
                stack.push(index);
            } else if (arr[index] == '*') {
                regex.push(index);
            } else if (arr[index] == ')') {
                if (stack.isEmpty() && regex.isEmpty()) {
                    return false;
                }

                if (!stack.isEmpty() && arr[stack.peek()] == '(') {
                    stack.pop();
                } else if (!regex.isEmpty() && arr[regex.peek()] == '*') {
                    regex.pop();
                }
            }
        }

        while (!regex.isEmpty() && !stack.isEmpty()) {
            int index = stack.pop();
            char ch = arr[index];
            if(ch == '(' && !regex.isEmpty() && index < regex.peek() ) {
                regex.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("(****))"));
        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }
}

