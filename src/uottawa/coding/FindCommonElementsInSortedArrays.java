package uottawa.coding;

import java.util.Arrays;

public class FindCommonElementsInSortedArrays {

    public static int[] arr1 = {13, 27, 35, 40, 49, 55, 59};
    public static int[] arr2 = {17, 35, 39, 40, 55, 58, 60};

    public static void main(String[] args) {
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = 0;

        int[] common = new int[arr1.length];
        while(i >= 0 && j >= 0) {
            if (arr1[i] == arr2[j]) {
                common[k] = arr1[i];
                k++;
                i--;
                j--;
            } else if (arr2[j] > arr1[i]) {
                j--;
            } else {
                i--;
            }
        }

        System.out.println(Arrays.toString(common));
    }

}
