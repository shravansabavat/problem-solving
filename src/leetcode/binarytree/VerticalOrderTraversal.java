package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Integer>> verticals = new TreeMap<>();
        verticalTraversalUtil(root, verticals, 0);
        return verticals.entrySet().stream().map(entry -> {
            PriorityQueue<Integer> q = entry.getValue();
            List<Integer> values = new ArrayList<>();
            while (!q.isEmpty()) {
                values.add(q.poll());
            }
            return  values;
        }).collect(Collectors.toList());
    }

    public static void verticalTraversalUtil(TreeNode node, TreeMap<Integer, PriorityQueue<Integer>> verticals, int height) {
        if (node == null) {
            return;
        }
        verticalTraversalUtil(node.left, verticals, height - 1);
        PriorityQueue<Integer> levelNodes = verticals.get(height);
        if (levelNodes == null) {
            levelNodes = new PriorityQueue<>();
            verticals.put(height, levelNodes);
        }
        levelNodes.add(node.val);
        verticalTraversalUtil(node.right, verticals, height + 1);
    }

    public static void main(String[] args) {
        TreeNode root1 = input1();
        TreeNode root2 = input2();
        System.out.println(verticalTraversal(root1));
        System.out.println(verticalTraversal(root2));
    }

    private static TreeNode input1() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);

        root.left = left;
        root.right = right;

        right.left = rightLeft;
        right.right = rightRight;
        return root;
    }

    private static TreeNode input2() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);

        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;

        right.left = rightLeft;
        right.right = rightRight;
        return root;
    }
}

class Point {
    int distance;
    int value;

    Point(int distance, int value) {
        this.distance = distance;
        this.value = value;
    }
}
