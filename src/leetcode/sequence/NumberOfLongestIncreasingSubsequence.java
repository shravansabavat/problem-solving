package leetcode.sequence;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        int[] lis = new int[nums.length + 1];
        Arrays.fill(lis, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] <= lis[j]) {
                    lis[i] = 1 + lis[j];
                }
            }
            max = Math.max(max, lis[i]);
        }

        if (max == 1) {
            return nums.length;
        }
        int count = 0;
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] == max - 1) {
                count++;
            }
        }
        return count;
    }

    public static int findNumberOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] maxLens = new int[nums.length];// length of longest increasing sequence start from i
        int[] counts = new int[nums.length]; // number of length of longest increasing sequence start from i
        int maxLen = 1; // length of longest increasing subsequnce
        maxLens[nums.length-1] = 1;
        counts[nums.length-1] = 1;

        for(int i = nums.length -2; i>=0; i--){//Backward iteration, i is used as the first character
            int curMax = 1;
            int count = 1;
            for(int j = i+1; j < nums.length; j++) {//j is used as the second character
                if(nums[i] < nums[j]){//increasing number
                    if (curMax == maxLens[j]+1)//means have another way to reach the same max length increasing sequence
                        count += counts[j];  //Important: not ++
                    else if (curMax < maxLens[j]+1){
                        count = counts[j];
                        curMax = maxLens[j]+1;
                    }
                }
            }
            maxLens[i] = curMax;
            counts[i] = count;
            maxLen = Math.max(maxLen, curMax);
        }
        int count = 0;
        for(int i = 0; i< maxLens.length; i++){//check each possible start position
            if (maxLens[i] == maxLen)
                count += counts[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int[] nums2 = {2,2,2,2,2};
        int[] nums3 = {5,8,7,1,9};
        int[] nums4 = {1,2,4,3,5,4,7,2};
//        System.out.println(findNumberOfLIS(nums));
//        System.out.println(findNumberOfLIS(nums2));
//        System.out.println(findNumberOfLIS(nums3));
        System.out.println(findNumberOfLIS(nums4));
        System.out.println(findNumberOfLIS1(nums4));
    }
}
