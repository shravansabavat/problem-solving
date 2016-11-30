package uottawa.coding;

import java.util.HashSet;

public class DuplicateInteger {

    public static int[] arr = {1, 2, 2, 4, 5, 2, 6};

    public static void main(String[] args) {

        arr[0] = -1*arr[0];
        for (int index = 0; index < arr.length; index++) {
            int k = Math.abs(arr[index]);
            arr[k] = -1*arr[k];
        }

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] > 0) {
                System.out.println(index);
                break;
            }
        }

        duplicateInTwoArrays();
    }

    public static void duplicateInTwoArrays() {
        int[] arr1 = {1, 2, 3, 4, 7};
        int[] arr2 = {1, 2, 3, 4, 7, 8};

        HashSet set = new HashSet();

        int[] largerArr = arr1.length > arr2.length ? arr1 : arr2;
        int[] smallerArr = arr1.length < arr2.length ? arr1 : arr2;
        for (int i : smallerArr) {
            set.add(i);
        }

        for (int i : largerArr) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }

        int index = 0;
        boolean found = false;;
        while (index < smallerArr.length) {
            if (largerArr[index] != smallerArr[index]) {
                System.out.println(largerArr[index]);
                found = true;
            }
            index++;
        }
        
        if (!found) {
            System.out.println(largerArr[index]);
        }
    }

}
