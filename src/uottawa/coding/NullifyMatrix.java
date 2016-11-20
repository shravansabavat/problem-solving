package uottawa.coding;

import java.util.Arrays;

public class NullifyMatrix {
    private static int[][] arr = {{1,2,0,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(arr));
        nullifyMatrix();
        System.out.println(Arrays.deepToString(arr));
    }

    private static void nullifyMatrix() {
        boolean[] rows = new boolean[arr.length];
        boolean[] cols = new boolean[arr[0].length];

        for (int row = 0; row < arr.length;row++) {
            for (int col = 0; col < arr[0].length;col++) {
                if (arr[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        for (int row = 0;row < arr.length;row++) {
            if (rows[row]) {
                nullifyRow(row);
            }
        }

        for (int col = 0;col < arr.length;col++) {
            if (cols[col]) {
                nullifyCol(col);
            }
        }
    }

    private static void nullifyCol(int col) {
        for (int row = 0;row < arr.length;row++) {
            arr[row][col] = 0;
        }
    }

    private static void nullifyRow(int row) {
        for (int col = 0;col < arr.length;col++) {
            arr[row][col] = 0;
        }
    }

}
