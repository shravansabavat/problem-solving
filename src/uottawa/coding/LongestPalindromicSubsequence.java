package uottawa.coding;

import javafx.util.Pair;

public class LongestPalindromicSubsequence {
    public static String str = "abciivviiasc";

    public static int calculate1(char []str){
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][str.length-1];
    }

    private static boolean isValidIndex(char[] a, int i) {return i >= 0 && i < a.length;}

    public static Pair getMaxPallindrome(String str) {
        Pair result = null;
        int longest = Integer.MIN_VALUE;
        char[] chars = str.toCharArray();
        //odd
        for(int index = 0; index < chars.length; index++) {
            int offset = 0;
            while (isValidIndex(chars, index - offset - 1)
                    &&  isValidIndex(chars, index + offset + 1)
                    && chars[index - offset - 1] == chars[index + 1 + offset ]) {
                offset++;
            }
            int longestIndex = 2 * offset + 1;
            if (longest < longestIndex) {
                longest = longestIndex;
                result = new Pair(index - offset, index + offset);
            }
        }

        //even
        for(int index = 0; index < chars.length; index++) {
            int offset = 0;
            while (isValidIndex(chars, index - offset)
                    &&  isValidIndex(chars, index + offset + 1)
                    && chars[index - offset] == chars[index + 1 + offset ]) {
                offset++;
            }

            int longestIndex = 2 * offset + 1;
            if (longest < longestIndex) {
                longest = longestIndex;
                result = new Pair(index - offset + 1, index + offset);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate1(str.toCharArray()));
        Pair<Integer, Integer> pair = getMaxPallindrome(str);
        System.out.println(str.substring(pair.getKey(), pair.getValue() + 1));
    }

}
