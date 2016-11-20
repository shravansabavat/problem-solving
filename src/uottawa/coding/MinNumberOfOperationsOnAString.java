package uottawa.coding;

public class MinNumberOfOperationsOnAString {
    
    public static String str1 = "abcdef";
    public static String str2 = "abced";
    
    public static void main(String[] args) {
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int[][] table = new int[str1.length() + 1][str2.length() + 1];
        
        for (int col = 0; col < table[0].length; col++) {
            table[0][col] = col;
        }
        
        for (int row = 0; row < table.length; row++) {
            table[row][0] = row;
        }
        
        for (int row = 1; row < table.length;row++) {
            for (int col = 1; col < table[0].length;col++) {
                if (str1Arr[row - 1] == str2Arr[col - 1]) {
                    table[row][col] = table[row-1][col-1];
                } else {
                    table[row][col] = 1 + Math.min(table[row-1][col-1], Math.min(table[row-1][col], table[row][col-1]));
                }
            }
        }
        
        System.out.println(table[str1.length()][str2.length()]);
    }

}
