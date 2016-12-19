package uottawa.winter.problems.binarytree;


public class HourglassMaxSum {

    public static void getRepatingElement() {
        int[] arr = {3, 4, 1, 3, 1, 7, 2, 2, 4};
        int index = 1;
        int max = arr[0];
        for(int num : arr) {
            if (max < num) {
                max = num;
            }
        }
        int[] indexedArr = new int[max + 1];
        index = 0;
        for(int num : arr) {
            if (indexedArr[num] <= 0) {
                indexedArr[num] = 1;
            } else {
                indexedArr[num] = 2;
            }

        }

        index = 0;
        for(int num : indexedArr) {
            if (num == 1) {
                System.out.println(index);
            } 
            index++;
        }

    }

    public static void printCommonElements() {
        int[] arr1 = {1, 2, 3, 6, 7};
        int[] arr2 = {1, 2, 3, 6, 7};
        //binary search
    }

    public static void main(String[] args) throws Exception {

        getRepatingElement();
    }
}
