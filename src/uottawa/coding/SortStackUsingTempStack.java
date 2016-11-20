package uottawa.coding;

import java.util.Stack;

public class SortStackUsingTempStack {
    
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2, 0};
        
        Stack<Integer> actualStack = new Stack<Integer>();
        Stack<Integer> tempStack = new Stack<Integer>();
        
        for (int index = 0; index < arr.length; index++) {
            if (actualStack.isEmpty() || actualStack.peek() < arr[index]) {
                actualStack.push(arr[index]);
            } else {
                tempStack.push(actualStack.pop());
                while(!actualStack.isEmpty() && actualStack.peek() > arr[index]) {
                    tempStack.push(actualStack.pop());
                }
                actualStack.push(arr[index]);
                
                while(!tempStack.isEmpty()) {
                    actualStack.push(tempStack.pop());
                }
            }
        }
        
        for (int i : actualStack) {
            System.out.println(i);
        }
        
    }

}
