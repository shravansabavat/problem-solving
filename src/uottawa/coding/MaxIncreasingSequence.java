package uottawa.coding;

import java.util.Arrays;

public class MaxIncreasingSequence {

    static int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};

    public static void main(String[] args) {

        int[] longestIncreasingSubSequence = getMaxSubSequence();

        System.out.println(Arrays.toString(longestIncreasingSubSequence));
    }

    private static int[] getMaxSubSequence() {
        int[] longestIncreasingSubSequence = new int[arr.length];

        longestIncreasingSubSequence[0] = arr[0];
        int currIndex = 0;
        for (int index = 1; index < arr.length; index++) {
            if (arr[index] > longestIncreasingSubSequence[currIndex]) {
                longestIncreasingSubSequence[++currIndex] = arr[index];
            }
        }

        return longestIncreasingSubSequence;
    }
}
