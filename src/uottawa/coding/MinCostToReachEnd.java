package uottawa.coding;

public class MinCostToReachEnd {

    public static int[][] arr = {{1, 3, 5, 8}, {4, 2, 1, 7}, {4, 3, 2, 3}};

    public static void main(String[] args) {
        int[][] table = new int[arr.length][arr[0].length];

        for (int row = 0; row < arr.length; row++) {
            if (row == 0) {
                table[row][0] = arr[row][0];
            } else {
                table[row][0] +=  arr[row][0] + arr[row - 1][0];
            }
        }

        for (int col = 0; col < arr[0].length; col++) {
            if (col == 0) {
                table[0][col] = arr[0][col];
            } else {
                table[0][col] +=  arr[0][col] + arr[0][col - 1];
            }
        }

        for (int row = 1; row < arr.length; row++) {
            for (int col = 1; col < arr[0].length; col++) {
                table[row][col] = arr[row][col] + Math.min(table[row - 1][col], table[row][col - 1]);
            }
        }

        System.out.println(table[arr.length - 1][arr[0].length - 1]);
    }
}