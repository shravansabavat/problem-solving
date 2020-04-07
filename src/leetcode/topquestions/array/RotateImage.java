package leetcode.topquestions.array;

import java.util.Arrays;

public class RotateImage {
    private static int[][] matrix =
            {
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
            };

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrix));
        rotate(matrix, 4);

        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotate(int[][] matrix, int n) {
        int layers = (int)Math.ceil(matrix.length/2);
        for (int layer = 0; layer < layers; layer++) {
            int first = layer;
            int last = n - layer -1;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int temp = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = temp;
            }
        }
    }
}
