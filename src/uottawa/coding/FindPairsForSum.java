package uottawa.coding;

import java.util.Arrays;
import java.util.HashMap;



public class FindPairsForSum {

    public static int[] arr1 = {1,3,5,6,9};
    public static int[] arr2 = {2,4,7,8,10};
    public static int sum = 10;

    public static void main(String[] args) {
        sortedSolution();
        withoutSortingSolution();
    }

    private static void sortedSolution() {
        int i = 0;
        int j = arr2.length - 1;


        while (i < arr1.length - 1 && j >= 0) {
            if (arr1[i] + arr2[j] > sum) {
                j--;
            } else {
                //print all values from i to j
                int k = j;
                while (k >= 0) {
                    System.out.println("pairs " + arr1[i] + ", " + arr2[k--]);
                }
                i++;
            }
        }
    }

    private static void withoutSortingSolution() {
        //sort the bigger arr length
        //iterate over smaller array and binary search for the difference
        int[] bigger;
        int[] smaller;
        if (arr1.length > arr2.length) {
            bigger = arr1;
            smaller = arr2;
        } else {
            bigger = arr2;
            smaller = arr1;
        }

        Arrays.sort(bigger);

        for (int index = 0; index < smaller.length; index++) {
            if (smaller[index] > sum) {
                continue;
            }
            int difference = sum - smaller[index];
            int found = findClosestIndex(bigger, 0, bigger.length - 1, difference);

            if (found >= 0) {
                for (int matchingIndex = 0; matchingIndex <= found; matchingIndex++) {
                    System.out.println("pair " + smaller[index] + ", " + bigger[matchingIndex]);
                }
            }
        }
    }


    private static int findClosestIndex(int[] arr, int low, int high, int difference) {
        if (low >= high) {

            if (arr[low] > difference) {
                return low - 1;
            }

            if (arr[high] > difference) {
                return high - 1;
            }
            return high-1;
        }

        int mid = ( low + high )/2;

        if (arr[mid] <= difference) {
            return findClosestIndex(arr, mid + 1, high, difference);
        } else if (arr[mid] >= difference) {
            return findClosestIndex(arr, low, mid - 1, difference);
        } else {
            return -1;
        }
    }
}
