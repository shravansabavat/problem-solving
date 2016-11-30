package uottawa.coding;


public class MatrixSpiralPrint {
    private static int[][] arr = 
        {
            {1,2,3,4,20,1}, 
            {5,6,7,8,30,2}, 
            {9,10,11,12,40,3},
            {13,14,15,16,50,4},
            {60,70,80,90,100,5},
            {1660,170,180,190,160,5}
        };
    
    public static void main(String[] args) {
        spiralPrint(arr, 6);
    }

    private static void spiralPrint(int[][] arr2, int n) {
        int layers = n/2;
        
        for (int layer = 0; layer < layers; layer++) {
            //first row
            int row = layer;
            int col = layer;
            for (int index = col; index <= n - layer - 1; index++) {
                System.out.print(arr[row][index] + " ");
            }
            //last column
            row = layer + 1;
            col = n - layer - 1;
            for (int index = row; index <= n - layer - 1; index++) {
                System.out.print(arr[index][col] + " ");
            }
            
            //last row
            row = n - layer - 1;
            col = n - layer - 2;
            for (int index = col; index >= layer; index--) {
                System.out.print(arr[row][index] + " ");
            }
            
            //first column
            row = n - layer - 2;
            col = layer;
            for (int index = row; index > layer; index--) {
                System.out.print(arr[index][col] + " ");
            }
        }
        
        if (n%2 != 0) 
            System.out.print(arr[n/2][n/2]);
    }
}
