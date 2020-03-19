package uottawa.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        //6
        //8
        //8 - 3 + 1
        System.out.println(Arrays.deepToString(median(arr, 3)));
    }

    public static Double[] median(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Double[] res = new Double[arr.length - k + 1];
        for (int index = 0; index < arr.length; index++) {
            int minHeapSize = minHeap.size();
            int maxHeapSize = maxHeap.size();
            if (minHeapSize + maxHeapSize >= k) {
                if (minHeap.contains(arr[index - k])) {
                    minHeap.remove(arr[index - k]);
                } else {
                    maxHeap.remove(arr[index - k]);
                }
            }
            maxHeap.add(arr[index]);
            minHeap.add(maxHeap.poll());
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
            if (index >= k - 1) {
                if (minHeap.size() == maxHeap.size()) {
                    res[index-k+1] = ((double)(minHeap.peek())+(double)(maxHeap.peek()))/2.0;
                } else {
                    res[index-k+1] = (double)minHeap.peek();
                }
            }

        }


        return res;
    }
}
