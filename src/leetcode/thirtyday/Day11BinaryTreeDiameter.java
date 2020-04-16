package leetcode.thirtyday;

public class Day11BinaryTreeDiameter {
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Day11BinaryTreeDiameter s = new Day11BinaryTreeDiameter();
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode rootLeftLeft = new TreeNode(4);
        TreeNode rootLeftRight = new TreeNode(5);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;
        System.out.println(diameterOfBinaryTree(root));
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
