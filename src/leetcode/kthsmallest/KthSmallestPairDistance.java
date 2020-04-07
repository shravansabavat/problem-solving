package leetcode.kthsmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPairDistance {

    public static int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<KthPair> queue = new PriorityQueue<>((o1, o2) -> Math.abs(o1.y - o1.x) - Math.abs(o2.y - o2.x));

        for (int i = 0; i < nums.length; i++)  {
            for (int j = i + 1; j < nums.length; j++)  {
                KthPair pair = new KthPair(nums[i], nums[j]);
                queue.add(pair);
            }
        }

        KthPair pair = null;
        while(k > 0) {
            pair = queue.poll();
            k--;
        }

        return Math.abs(pair.getY() - pair.getX());
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1};
        int[] nums1 = {62,100,4,100};
        //int[] nums2 = {1,3,1};
        //System.out.println(smallestDistancePair(nums, 1));
        System.out.println(smallestDistancePair(nums1, 1));
        //System.out.println(smallestDistancePair(nums2, 1));
    }
}
