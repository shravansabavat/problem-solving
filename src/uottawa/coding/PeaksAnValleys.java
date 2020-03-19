package uottawa.coding;

import java.util.Arrays;


public class PeaksAnValleys {
    static int[] arr = {5, 3, 1, 2, 3};
    
    public static void main(String[] args) {
        
        for (int index = 1; index < arr.length; index = index + 2) {
            int maxIndex = findmaxIndex(arr, index - 1, index, index + 1);
            if (maxIndex != index) {
                swap(index, maxIndex);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int index, int maxIndex) {
        int temp = arr[index];
        arr[index] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    private static int findmaxIndex(int[] arr, int a, int b, int c) {
        int aValue = a >= 0 ? arr[a] : Integer.MIN_VALUE;
        int bValue = b < arr.length ? arr[b] : Integer.MIN_VALUE;
        int cValue = c < arr.length ? arr[c] : Integer.MIN_VALUE;
        
        int max = Math.max(aValue, Math.max(bValue, cValue));
        
        if (max == aValue) {
            return a;
        } else if (max == bValue) {
            return b;
        } else {
            return c;
        }
    }
}
