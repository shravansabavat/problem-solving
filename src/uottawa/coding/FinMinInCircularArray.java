package uottawa.coding;

public class FinMinInCircularArray {
    public static int[] arr = {38, 40, 1, 2, 6, 13, 20, 23, 36};

    public static void main(String[] args) {
        int index = findMin();
        System.out.println(arr[index]);
    }

    public static int findMin() {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high)/2;

        while(low <= high) {
            mid = (low + high)/2;
            
            int midValue = arr[mid];
            int midLeft = arr[mid - 1];
            int midRight = arr[mid + 1];

            if (midRight < arr[mid]) {
                return mid + 1;
            }

            if (midValue < midLeft) {
                return mid;
            }

            if (arr[high] > arr[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
