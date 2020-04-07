package leetcode.thirtyday;

public class Day4MoveZeros {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int i = 0, j = nums.length - 1;
        int lastNonZeroIndex = i;
        while (i < j) {
            if (nums[i] == 0) {
                lastNonZeroIndex = getFirstNonZeroIndex(nums, lastNonZeroIndex + 1);
                if (lastNonZeroIndex == Integer.MIN_VALUE) {
                    break;
                }
                swap(nums, i, lastNonZeroIndex);
            }
            i++;
            if (lastNonZeroIndex < i) {
                lastNonZeroIndex = i;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int getFirstNonZeroIndex(int[] nums, int currentIndex) {
        while(currentIndex < nums.length) {
            if (nums[currentIndex] != 0) {
                return currentIndex;
            } else {
                currentIndex++;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
        System.out.println(nums);
    }
}
