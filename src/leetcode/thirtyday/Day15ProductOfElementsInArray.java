package leetcode.thirtyday;

import java.util.Arrays;

public class Day15ProductOfElementsInArray {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] product = new int[nums.length];
        Arrays.fill(product, 1);

        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            product[i] = temp;
            temp *= nums[i];
        }

        temp = 1;
        for (int i = nums.length - 1; i >=0 ; i--) {
            product[i] *= temp;
            temp *= nums[i];
        }

        return product;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}

