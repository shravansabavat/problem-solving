package uottawa.coding;

public class SparseSearchWithEmptyStrings {
    
    public static void main(String[] args) {
        String[] arr = {"a", "", "b", "", "", "", "c"};
        
        int stringIndex = findString(arr, "c");
        System.out.println(stringIndex);
    }

    private static int findString(String[] arr, String search) {
        return findIndexByBinarySearch(arr, 0, arr.length - 1, search);
    }
    
    private static int findIndexByBinarySearch(String[] arr, int start, int end, String search) {
        if (start > end) {
            return -1;
        }
        
        int mid = (start + end)/2;
        if (arr[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            
            while (true) {
                if (left < start && right > end) {
                    return -1;
                }
                
                if (left >= start && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                } else if (right >= end && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                }
                
                left--;
                right++;
            }
        }
        
        if (arr[mid].equals(search)) {
            return mid;
        } else if (search.compareTo(arr[mid])  > 0) {
            return findIndexByBinarySearch(arr, mid + 1, end, search);
        } else {
            return findIndexByBinarySearch(arr, start, mid - 1, search);
        }
    }

}
