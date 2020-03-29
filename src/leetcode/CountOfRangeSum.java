package leetcode;

public class CountOfRangeSum {

//    public static int countRangeSum(int[] nums, int lower, int upper) {
//        int[][] sumTracker = new int[nums.length][nums.length];
//
//        for ()
//        return -1;
//    }

    public static void main(String[] args) {

    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] accumulativeSum = new long[nums.length + 1];

        for (int i = 1; i < accumulativeSum.length; i++) {
            accumulativeSum[i] = accumulativeSum[i - 1] + nums[i - 1];
        }

        return countRangeSumUtil(accumulativeSum, lower, upper);
    }

    private int countRangeSumUtil(long[] nums, int lower, int upper) {
        int numRangeSum = 0;

        for (int j = 0; j < nums.length; j++) {
            for (int i = 1; i - 1 < j; i++) {
                if (nums[j] >= nums[i - 1] + lower
                        && nums[j] <= nums[i - 1] + upper) {
                    // S(i, j) is valid
                    numRangeSum++;
                }
            }
        }

        return numRangeSum;
    }
}
