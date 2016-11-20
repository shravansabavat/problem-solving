package uottawa.coding;

public class FindNegativeNumberInMatrix {
    private static int[][] arr = {{-1,-2,3,4},
                                  {-5,6,7,8},
                                  {-9,10,11,12},
                                  {13,14,15,16}};
    
    public static void main(String[] args) {
        System.out.println(findNegatives(arr, 4, 4));
    }

    private static int findNegatives(int[][] arr, int n, int m) {
        int rowIndex = 0;
        int colIndex = m - 1;
        int count = 0;
        while (colIndex >= 0 && rowIndex < n) {
            if (arr[rowIndex][colIndex] < 0) {
                count += colIndex + 1;
                rowIndex += 1;
            } else {
                colIndex -= 1;
            }
        }
        return count;
    }

}
