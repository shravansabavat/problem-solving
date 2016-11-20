package uottawa.coding;

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
    }

}
