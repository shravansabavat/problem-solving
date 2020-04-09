package leetcode.topquestions.array;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        int[] newResult = new int[digits.length + 1];
        int carry = 1;
        for (int index = digits.length - 1; index >= 0; index--) {
            int sum = digits[index] + carry;
            int add = sum % 10;
            carry = sum / 10;
            result[index] = add;
        }

        if (carry > 0) {
            int index = digits.length;
            for (int num : result) {
                newResult[index--] = num;
            }
            newResult[0] = carry;
            return newResult;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
}
