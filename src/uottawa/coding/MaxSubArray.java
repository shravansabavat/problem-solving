package uottawa.coding;

public class MaxSubArray {
    
    static int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

    public static void main(String[] args) {
        int max = arr[0];
        int maxGlobal = max;
        for (int index = 1; index < arr.length; index++) {
            max = Math.max(arr[index],  arr[index] + max);
            maxGlobal = Math.max(max, maxGlobal);
        }
        
        System.out.println(maxGlobal);
    }
}
