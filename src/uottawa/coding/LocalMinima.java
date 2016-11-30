package uottawa.coding;

public class LocalMinima {
    
    public static int[] arr = {10, 23, 11, 9, 14, 8, 1 };
    public static int[] arr1 = {4, 1, 3, 3, 3, 4, 5, 6};
    
    public static void main(String[] args) {
        System.out.println(getLocalMinima(arr, arr.length));
        System.out.println(getLocalMinima(arr1, 0, arr1.length - 1));
    }

    /**
      Find a local minima in an array of unique integers.
      [ 10, 23, 11, 9, 14, 8, 1 ]
      Output : 9
      [10, 23, 11, 11, 11, 16, 14, 8, 1]
     **/
    //test case 1: to pass in an empty/null arr and check if you are getting a Integer Min value
    //test case 2: to send just one element in the array, in this case we should return that element
    //test case 3: to send just 2 values in the array, in this case we return the minimum value
    //test case 4: to send an array with size greater than 2, should return the local minima.

    public static int getLocalMinima(int[] arr, int size) {
        if (arr == null || size == 0) {
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            return arr[0];
        }

        if (size == 2) {
            return Math.min(arr[0], arr[1]);
        }

        for (int index = 1; index < size - 2; index++) {
            int left = arr[index - 1];
            int right = arr[index + 1];
            if (arr[index] < left && arr[index] < right) {
                return arr[index];
            }
        }

        return Integer.MIN_VALUE;
    }

    public static int getLocalMinima(int[] arr, int low, int high) {
        int mid = (low + high)/2;
        int midLeft = mid - 1;
        int midRight = mid + 1;

        
        if (mid == 0) {
            return Math.min(arr[mid], arr[midRight]);
        }
        
        if (mid == high) {
            return Math.min(arr[mid], arr[midLeft]);
        }
        
        if (arr[mid] < arr[midLeft] && arr[mid] < arr[midRight]) {
            return arr[mid]; 
        } else if (arr[midLeft] <= arr[mid]) {
            return getLocalMinima(arr, low, mid - 1);
        } else if (arr[midRight] <= arr[mid]) {
            return getLocalMinima(arr, mid + 1, high);
        } else {
            return Integer.MIN_VALUE; 
        }
    }   

}
