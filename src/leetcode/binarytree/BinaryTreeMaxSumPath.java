package leetcode.binarytree;

public class BinaryTreeMaxSumPath {
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathSumUtil(root);

        return max;
    }

    public static int maxPathSumUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode rootLeftLeft = new TreeNode(4);
        TreeNode rootLeftRight = new TreeNode(5);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;
        System.out.println(maxPathSum(root));
    }
}

class MutableInteger {
    public int x;

    public MutableInteger(int x) {
        this.x = x;
    }
}
