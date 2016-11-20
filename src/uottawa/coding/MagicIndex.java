package uottawa.coding;

public class MagicIndex {

    public static void main(String[] args) {
        int[] arr = {-40, -10, 2, 2, 3, 4, 5, 8, 9, 10};

        System.out.println(getMagiceIndexRecursively(arr, 0, arr.length - 1));
    }

    private static int getMagiceIndexRecursively(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end)/2;
        if (arr[mid] == mid) {
            return mid;
        } 
        
        int leftIndex = Math.min(mid - 1, arr[mid]);
        int left = getMagiceIndexRecursively(arr, start, leftIndex);
        
        if (left > -1) {
            return left;
        }
        
        int rightIndex = Math.max(mid + 1, arr[mid]);
        int right = getMagiceIndexRecursively(arr, mid + 1, rightIndex);
        
        if (right > -1) {
            return right;
        }

        return -1;
    }


}
