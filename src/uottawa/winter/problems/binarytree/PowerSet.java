package uottawa.winter.problems.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static <T> List<List<T>> powerSet(List<T> originalSet, int index) {
        List<List<T>> allSubsets;
        if (originalSet.size() == index) {
            allSubsets = new ArrayList<List<T>>();
            allSubsets.add(new ArrayList<T>());
        } else {
            allSubsets = powerSet(originalSet, index + 1);

            T item = originalSet.get(index);
            List<List<T>> moreSubSets = new ArrayList<List<T>>();

            for (List<T> list : allSubsets) {
                List<T> newSubSet = new ArrayList<T>();
                newSubSet.addAll(list);
                newSubSet.add(item);
                moreSubSets.add(newSubSet);
            }

            allSubsets.addAll(moreSubSets);
        }

        return allSubsets;
    }

    public static void main(String[] args) {
        List<Integer> mySet = new ArrayList<Integer>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);

        int expectedSum = 6;
        List<List<Integer>> allSubSets = powerSet(mySet, 0);
        for (List<Integer> s : allSubSets) {
            int sum = 0;
            for (Integer i : s) {
                sum += i;
            }

            if (sum == expectedSum) {
                System.out.println(s);
            }
        }
    }

}
