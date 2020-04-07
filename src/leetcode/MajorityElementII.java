package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return majorityList;
        }

        if (nums.length == 1) {
            return Arrays.asList(nums[0]);
        }

        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                candidate1 = num;
            } else if (count2 == 0) {
                count2++;
                candidate2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        int c1Frequencey = 0, c2Frequencey = 0;
        int requiredFrequency = nums.length / 3;
        if (count1 > 0 || count2 > 0) {
            for (int num : nums) {
                if (candidate1 == num) {
                    c1Frequencey++;
                }
                if (candidate2 == num) {
                    c2Frequencey++;
                }
            }
        }

        if (c1Frequencey > requiredFrequency) {
            majorityList.add(candidate1);
        }

        if (c2Frequencey > requiredFrequency) {
            majorityList.add(candidate2);
        }
        return majorityList;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(nums));
    }
}
