package leetcode.thirtyday;

import java.util.HashSet;
import java.util.Set;

public class Day7CountingElements {
    public static int countElements(int[] arr) {
        Set<Integer> tracker = new HashSet<>();
        for (int num : arr) {
            tracker.add(num);
        }

        int count = 0;
        for (int num : arr) {
            int potentialElement = num + 1;
            if (tracker.contains(potentialElement)) {
                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {13,10,11,9,6,0,1,6,1,13,9,3,2,6,5};
        System.out.println(countElements(nums));
    }
}
