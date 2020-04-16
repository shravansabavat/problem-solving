package leetcode.thirtyday;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Day12LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int weight : stones) {
            queue.add(weight);
        }

        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();

            int diff = first - second;
            queue.add(diff);
        }

        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weights = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(weights));
    }
}

