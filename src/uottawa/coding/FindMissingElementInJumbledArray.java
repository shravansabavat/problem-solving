package uottawa.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingElementInJumbledArray {
    public static int[] arr1 = { 1, 3, 4, 5, 2, 7 };
    public static int[] arr2 = { 4, 1, 2, 5, 7, 3 };

    public static void main(String[] args) {
        int arr1Index = 0;
        int arr2Index = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            sum1 += arr1[arr1Index++];
        }

        while (arr2Index < arr2.length) {
            sum2 += arr2[arr2Index++];
        }

        System.out.println(Math.abs(sum1 - sum2));

        List<Integer> array1 = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 2, 7));
        List<Integer> array2 = Arrays.asList(4, 1, 2, 5, 7, 3);

        array1.addAll(array2);
        Integer missing = array1.stream().reduce(0, (x, y) -> x ^ y);

        System.out.println(missing);
    }

}
