package leetcode.thirtyday;

import java.util.Stack;

public class Day10MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public Day10MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int currMin = minStack.peek();
            if (x <= currMin) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int value = stack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int len = minStack.size();
        if (len == 0) {
            return 0;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        Day10MinStack s = new Day10MinStack();
        s.push(2);
        s.push(0);
        s.push(3);
        s.push(0);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }
}

