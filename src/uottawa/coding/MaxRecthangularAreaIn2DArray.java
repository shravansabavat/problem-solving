package uottawa.coding;

import java.util.Stack;

public class MaxRecthangularAreaIn2DArray {
    static int arr[][] = 
        {
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {0, 1, 1, 1},
            {0, 1, 1, 1}
        };


    public static void main(String[] args) {
        int[] temp = new int[arr.length];
        int maxArea = Integer.MIN_VALUE;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                if (arr[row][col] == 1) {
                    temp[col] += 1;
                } else {
                    temp[col] = 0;
                }
            }
            
           int  newMaxArea = largestRectangleArea(temp);
           maxArea = Math.max(maxArea, newMaxArea);
        }
        
        System.out.println(maxArea);
    }

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.length) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }
}
