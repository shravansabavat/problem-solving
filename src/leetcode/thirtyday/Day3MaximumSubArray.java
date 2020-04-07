package leetcode.thirtyday;

public class Day3MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        int globalSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            globalSum = Math.max(max, globalSum);
        }
        return globalSum;
    }

    public static int dqmaxSubArray(int[] nums) {
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
