package leetcode.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalSum {

    public static List<Integer> verticalSum(TreeNode root) {
        TreeMap<Integer, LinkedList> verticals = new TreeMap<>();
        verticalSumUtil(root, verticals, 0);

        return verticals.entrySet().stream().map(entry -> {
            LinkedList<Integer> values = entry.getValue();
            return values.stream().mapToInt(i -> i.intValue()).sum();
        }).collect(Collectors.toList());
    }

    public static void verticalSumUtil(TreeNode node, TreeMap<Integer, LinkedList> verticals, int height) {
        if (node == null) {
            return;
        }
        verticalSumUtil(node.left, verticals, height - 1);
        LinkedList<Integer> levelNodes = verticals.get(height);
        if (levelNodes == null) {
            levelNodes = new LinkedList<>();
            verticals.put(height, levelNodes);
        }
        levelNodes.add(node.val);
        verticalSumUtil(node.right, verticals, height + 1);
    }

    public static void main(String[] args) {
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
        System.out.println(verticalSum(root));
    }
}
