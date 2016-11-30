package uottawa.coding;

public class NearestLargerValue {
    static int[] arr = {7, 2, 3, 4, 2, 5, 6, 8};
    static int num = 4;

    public static void main(String[] args) {

        int inputNumIndex = -1;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == num) {
                inputNumIndex = index;
                break;
            }
        }

        int arrIndex = 0;
        int finalIndex = Integer.MAX_VALUE;
        if (inputNumIndex > -1) {
            while (arr[arrIndex] < arr.length) {
                if (arr[arrIndex] > num) {
                    if (finalIndex == Integer.MAX_VALUE) {
                        finalIndex = arrIndex;
                    } else {
                        int currDiff = Math.abs(inputNumIndex - arrIndex);
                        int previousDiff = Math.abs(inputNumIndex - finalIndex);
                        if (previousDiff > currDiff) {
                            finalIndex = arrIndex;
                        }
                    }
                }

                arrIndex++;
            }
        }

        System.out.println(arr[finalIndex]);
    }
}
