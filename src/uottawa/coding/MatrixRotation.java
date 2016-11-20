package uottawa.coding;

import java.util.Arrays;

public class MatrixRotation {
    
    private static int[][] arr = 
        {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12},
            {13,14,15,16}
        };
    
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(arr));
        rotate(arr, 4);
        
        System.out.println(Arrays.deepToString(arr));
    }

    private static void rotate(int[][] arr2, int n) {
        int layers = n/2;
        
        for (int layer = 0; layer < layers; layer++) {
            int first = layer;
            int last = n - layer -1;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int temp = arr[first][i];
                arr[first][i] = arr[last - offset][first];
                arr[last - offset][first] = arr[last][last - offset];
                arr[last][last - offset] = arr[i][last];
                arr[i][last] = temp;
            }
        }
    }

}
