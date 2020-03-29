package uottawa.winter.problems.binarytree;

public class BinarySearch {
    public static void main(String[] args){
        int arr[] = {1, 1, 2, 2, 4, 5, 6, 7, 8, 9};

        int find = 1;
        int low = 0;
        int high = arr.length - 1;
        int foundIndex = -1;
        while(low <= high) {
            int mid = (low + high)/2;

            if (arr[mid] == find) {
                if (mid - 1 >= 0 && arr[mid - 1] != find) {

                } else {
                    foundIndex = mid;
                    break;
                }
            } else if (find < arr[mid] || (mid - 1 >= 0 && arr[mid - 1] == find)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(foundIndex);
    }
}
