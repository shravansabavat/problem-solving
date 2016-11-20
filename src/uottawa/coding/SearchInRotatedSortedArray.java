package uottawa.coding;

public class SearchInRotatedSortedArray {
    
    public static void main(String[] args) {
        //int[] arr = {50, 60, 5, 20, 30, 40};
        int[] arr = {2, 2, 2, 3, 4, 2};
        System.out.println(findElement(arr, 0, arr.length - 1, 3));
    }

    private static int findElement(int[] arr, int start, int end, int search) {
        if (start > end) {
            return -1;
        }
        
        int mid = (start + end)/2;
        if (arr[mid] == search) {
            return mid;
        }
        
        if (arr[start] < arr[mid]) {
            if (search >= arr[start] && search < arr[mid]) {
                return findElement(arr, start, mid, search);
            } else {
                return findElement(arr, mid + 1, arr.length - 1, search);
            }
        } else if (arr[mid] < arr[end]){
            if (search > arr[mid] && search <= arr[end]) {
                return findElement(arr, mid + 1, end, search);
            } else {
                return findElement(arr, start, mid, search);
            }
        } else if (arr[start] == arr[mid]) {
            if (arr[mid] != arr[end]) {
                return findElement(arr, mid + 1, end, search);
            } else {
                int result = findElement(arr, start, mid - 1, search);
                if (result == -1) {
                    return findElement(arr, mid + 1, end, search);
                }
                
                return result;
            }
        }
        
        return -1;
    }

}
