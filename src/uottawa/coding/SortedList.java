package uottawa.coding;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedList extends ArrayList{

    
    public boolean add(Integer i) {
        int size = super.size();
        if (size == 0) {
            return super.add(i);
        }
        
        int end = size - 1;
        
//        int rightIndex = getRightIndex((Integer[])super.toArray(new Integer[0]), 0, super.size() - 1, i);
//        if (rightIndex == -1) {
//            rightIndex = 0;
//        }
//        super.add(rightIndex, i);
        
        while (end >= 0) {
            Integer j = (Integer)super.get(end);
            if (j.compareTo(i) < 0) {
                end = end + 1;
                break;
            } else {
                end--;
            }
        }
        if (end == -1) {
            end = 0;
        }
        super.add(end, i);
        
        return true;
    }
    
    private int getRightIndex(Integer[] arr, int low, int high, int number) {
        if (low > high) {
            return -1;
        }
        
        int mid = (low + high) / 2;
        int midLeft = mid - 1;
        int midRight = mid + 1;
        
        if (midRight < arr.length && number > arr[mid] && number < arr[midRight]) {
            return mid + 1;
        } else if (midLeft > -1 && number < arr[mid] && number > arr[midLeft]) {
            return mid - 1;
        } else if (midLeft > -1 && number < arr[mid] && number < arr[midLeft]) {
            high = midLeft - 1;
            return getRightIndex(arr, low, high, number);
        } else if (midRight < arr.length && number > arr[mid] && number > arr[midRight]) {
            high = midLeft - 1;
            return getRightIndex(arr, midRight + 1, high, number);
        }
        
        return -1;
    }

    public static void main(String[] args) {
        SortedList list = new SortedList();
        list.add(8);
        list.add(18);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(3);
        
        System.out.println(Arrays.deepToString(list.toArray()));
    }
}
