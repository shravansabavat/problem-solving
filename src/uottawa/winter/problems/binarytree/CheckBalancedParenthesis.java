package uottawa.winter.problems.binarytree;

import java.util.Stack;
 
public class CheckBalancedParenthesis {
    
    public static void main(String[] args) {
        String expression = "()()()";
        
        System.out.println(isValid(expression));
    }
    
    public static boolean isValid(String expression) {
        Stack<Character> myStack = new Stack<Character>();
        
        char[] chars = expression.toCharArray();
        for (char current : chars) {
            if (current == '(') {
                myStack.push(current);
            }
            
            if (current == ')') {
                if (myStack.isEmpty()) {
                    return false;
                }
                char last = myStack.peek();
                if (last == '(' && current == ')') {
                    myStack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return myStack.isEmpty();
    }

}
