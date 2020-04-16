package leetcode.thirtyday;

import java.util.HashMap;
import java.util.Map;

public class Day13ContiguousArray {

    public static int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = 0;
        Map<Integer,Integer> tracker = new HashMap<>();// key: sum  value:first index of sum
        for(int i = 0;i < nums.length; i++){
            sum += nums[i] == 1 ? 1 : -1;
            if(sum == 0) {
                max = i+1;
            } else if(tracker.containsKey(sum)){
                max = Math.max(max,i-tracker.get(sum));
            } else {
                tracker.put(sum,i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] nums = {0,0,0,1,1,1,0};
        //int[] nums = {0,1,0,1};
        int[] nums = {1,0,1,1,0,1,0,1,1,0};
        System.out.println(findMaxLength(nums));
    }
}

