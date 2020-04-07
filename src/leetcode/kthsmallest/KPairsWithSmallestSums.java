package leetcode.kthsmallest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSums {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<KthPair> queue = new PriorityQueue<>((o1, o2) -> (o1.x + o1.y) - (o2.x + o2.y));
        for (int i = 0; i < nums1.length; i++)  {
            for (int j = 0; j < nums2.length; j++)  {
                KthPair pair = new KthPair(nums1[i], nums2[j]);
                queue.add(pair);
            }
        }

        List<List<Integer>> finalList = new ArrayList<>();
        while(!queue.isEmpty() && k > 0) {
            List<Integer> list = new ArrayList<>();
            KthPair pair = queue.poll();
            list.add(pair.getX());
            list.add(pair.getY());
            finalList.add(list);
            k--;
        }

        return finalList;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int[] nums3 = {1,1,2};
        int[] nums4 = {1,2,3};

        System.out.println(kSmallestPairs(nums1, nums2, 3));
        System.out.println(kSmallestPairs(nums3, nums4, 3));
    }
}

