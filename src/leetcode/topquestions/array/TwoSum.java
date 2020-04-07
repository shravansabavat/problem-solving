package leetcode.topquestions.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tracker = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            if (tracker.containsKey(nums[index])) {
                return new int[]{index, tracker.get(nums[index])};
            } else {
                tracker.put(target - nums[index], index);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
