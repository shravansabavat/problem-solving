package uottawa.coding;


public class MaxSubSquareMatrix {
    
    static int arr[][] = 
        {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        };
    
    
    public static void main(String[] args) {
        int[][] table = new int[arr.length][arr[0].length];
        
        int max = 0;
        for (int row = 0; row < arr.length; row++) {
            table[row][0] = arr[row][0];
            if (arr[row][0] == 1) {
                max = 1;
            }
        }
        
        for (int col = 0; col < arr[0].length; col++) {
            table[0][col] = arr[0][col];
            if (arr[0][col] == 1) {
                max = 1;
            }
        }
        
        for (int row = 1; row < arr.length; row++) {
            for (int col = 1; col < arr[0].length; col++) {
                if (arr[row][col] == 1) {
                    int value = 1 + Math.min(table[row - 1][col], Math.min(table[row - 1][col - 1], table[row][col - 1]));
                    table[row][col] = value;
                    max = Math.max(max, value);
                }
            }
        }
        
        System.out.println(max);
    }

}
