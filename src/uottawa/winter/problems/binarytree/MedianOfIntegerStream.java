package uottawa.winter.problems.binarytree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfIntegerStream {

    public Queue<Integer> minHeap;
    public Queue<Integer> maxHeap;
    public int numOfElements;

    public MedianOfIntegerStream() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(10, new MaxHeapComparator());
        numOfElements = 0;
    }

    public void addNumberToStream(Integer num) {
        maxHeap.add(num);
        if (numOfElements % 2 == 0) {
            if (minHeap.isEmpty()) {
                numOfElements++;
                return;
            } else if (maxHeap.peek() > minHeap.peek()) {
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        } else {
            minHeap.add(maxHeap.poll());
        }
        numOfElements++;
    }

    public Double getMedian() {
        if (numOfElements % 2 != 0) {
            System.out.println(maxHeap.peek());
            return new Double(maxHeap.peek());
        } else
            System.out.println(minHeap.peek());
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    private class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        MedianOfIntegerStream streamMedian = new MedianOfIntegerStream();

        streamMedian.addNumberToStream(1);
        System.out.println(streamMedian.getMedian()); // should be 1

        streamMedian.addNumberToStream(2);
        streamMedian.addNumberToStream(3);
        streamMedian.addNumberToStream(4);
        streamMedian.addNumberToStream(5);
        streamMedian.addNumberToStream(6);
        streamMedian.addNumberToStream(7);
        streamMedian.addNumberToStream(8);
        streamMedian.addNumberToStream(9);
        streamMedian.addNumberToStream(10);
        System.out.println(streamMedian.getMedian()); // should be 5

    }
}