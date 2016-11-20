package uottawa.coding;

public class LongestSubSequence {

    static char[] str1 = "abcde".toCharArray();
    static char[] str2 = "abdeg".toCharArray();

    public static void main(String[] args) {
        int length = longestCommonSubsequence(str1.length, str2.length);
        System.out.println(length);
    }

    private static int longestCommonSubsequence(int m, int n) {
        int[][] table = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (str1[i - 1] == str2[j-1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }

        return table[m][n];
    }

}
