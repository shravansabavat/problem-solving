package leetcode.kthsmallest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.distance == o2.distance) {
                return (o1.value + o1.distance) - (o2.value + o2.distance);
            } else {
                return o1.distance - o2.distance;
            }
        });


        int[] distance = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            distance[i] = Math.abs(x - arr[i]);
            queue.add(new Pair(arr[i], distance[i]));
        }

        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            result.add(queue.poll().value);
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k=4, x=3;
//        int[] arr = {1,1,1,10,10,10};
//        int k=1, x=9;
        System.out.println(findClosestElements(arr, k, x));
    }
}

class Pair {
    int value;
    int distance;

    Pair(int value, int distance) {
        this.value = value;
        this.distance = distance;
    }
}
