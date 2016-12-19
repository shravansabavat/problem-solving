package uottawa.winter.problems.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

    Node root;

    public Node createBTNode(Node node, int data){
        if(node == null) {
            node = new Node(data);
            return node;
        } else if(node.getData() <= data) {
            node.left = createBTNode(node.getLeft(), data);
        } else if(node.getData() > data) {
            node.right = createBTNode(node.getRight(), data);
        }

        if (root == null) {
            root = node;
        }
        return node;
    }

    public int getCountOfPossiblePathsForSum(Node root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int pathsFromRoot = getCountOfPossiblePathsForSum(root, targetSum, 0);
        int pathsFromLeft = getCountOfPossiblePathsForSum(root.left, targetSum);
        int pathsFromRight = getCountOfPossiblePathsForSum(root.right, targetSum);

        return pathsFromRoot + pathsFromLeft + pathsFromRight;
    }


    private int getCountOfPossiblePathsForSum(Node node, int targetSum, int currentSum) {
        if (node == null) {
            return 0;
        }

        int totalPaths = 0;
        currentSum += node.data;
        if (currentSum == targetSum) {
            totalPaths++;
        }

        totalPaths += getCountOfPossiblePathsForSum(node.left, targetSum, currentSum);
        totalPaths += getCountOfPossiblePathsForSum(node.right, targetSum, currentSum);

        return totalPaths;
    }

    public Node findInOrderSuccessor(Node root, Node searchNode) {
        if (root == null) {
            return null;
        }

        Node succ = null;
        if (searchNode.right != null) {
            succ = findMin(searchNode.right);
        } else {
            while (root != null) {
                if (searchNode.data < root.data) {
                    succ = root;
                    root = root.left;
                } else if (searchNode.data > root.data) {
                    root = root.right;
                } else {
                    break;
                }
            }
        }

        return succ;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void createListsOfNodesAtEachLevel(Node root) {
        List<LinkedList<Node>> nodesAtEachLevel = new ArrayList<LinkedList<Node>>();
        createListOfNodesAtEachLevel(root, nodesAtEachLevel, 0);
    }

    private void createListOfNodesAtEachLevel(Node root, List<LinkedList<Node>> nodesAtEachLevel, int level) {
        if (root == null) {
            return;
        }

        LinkedList<Node> levelNodes = null;
        if (nodesAtEachLevel.get(level) == null) {
            levelNodes = new LinkedList<Node>();
        } else {
            levelNodes = nodesAtEachLevel.get(level);
        }

        levelNodes.add(root);
        createListOfNodesAtEachLevel(root.left, nodesAtEachLevel, level + 1);
        createListOfNodesAtEachLevel(root.right, nodesAtEachLevel, level + 1);
    }

    /* A recursive function to insert a new key in BST */
    public static Node deleteRec(Node root, int key) {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);

        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    static int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public Node findLowestCommonAncestor(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(n1 == root.data || n2 == root.data) {
            return root;
        }

        Node leftChildLca = findLowestCommonAncestor(root.left, n1, n2);
        Node rightChildLca = findLowestCommonAncestor(root.right, n1, n2);

        if(null != leftChildLca && null != rightChildLca) {
            return root;
        }else if(leftChildLca != null) {
            return leftChildLca;
        }else {
            return rightChildLca;
        }
    }

    public static boolean isTreeHeightBalancedNonEfficient(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 &&
                isTreeHeightBalancedNonEfficient(root.left) &&
                isTreeHeightBalancedNonEfficient(root.right);
    }

    public static boolean isTreeBalancedEfficient(Node root) {
        if (root == null) {
            return true;
        }

        int height = checkHeight(root);

        return height != Integer.MIN_VALUE;
    }

    private static int checkHeight(Node root) {
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(rightHeight - leftHeight) > 1) {
            return Integer.MIN_VALUE;
        }

        return Math.max(rightHeight, leftHeight) + 1;
    }

    public static int findDistance(Node node, int value) {
        if (node == null) {
            return -1;
        }

        if (value < 0) {
            return -1;
        }

        if (node.getData() == value) {
            return 0;
        }

        if (value < node.getData()) {
            return 1 + findDistance(node.left, value);
        } else {
            return 1 + findDistance(node.right, value);
        }

    }

    public static int getDiameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int leftDiameter = getDiameter(root.left);
        int rightDiameter = getDiameter(root.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static int findPossibleMatch(Node node, int number) {
        if (node == null) {
            return -1;
        }

        if (node.data == number) {
            return node.data;
        } else if (number > node.data) {
            node.diff = number - node.data;
            return findPossibleMatch(node.right, number);
        } else {
            node.diff = node.data - number;
            return findPossibleMatch(node.left, number);
        }
    }

    public static Node findNextPossibleMatch(Node node, int number, Node leastDiffNode) {
        if (node == null) {
            return leastDiffNode;
        }

        if (node.diff < leastDiffNode.diff) {
            leastDiffNode = node;
        }

        if (number > node.data) {
            return findNextPossibleMatch(node.right, number, leastDiffNode);
        } else {
            return findNextPossibleMatch(node.left, number, leastDiffNode);
        }

    }

    public static boolean checkIfMirrored(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.data == root2.data && 
                checkIfMirrored(root1.left, root2.right) && 
                    checkIfMirrored(root1.right, root2.left);
    }
    
    public static boolean checkIfPathExists(Node node, String str) {
        char ch = str.charAt(0);
        Integer i = Integer.parseInt(String.valueOf(ch));
        
        boolean pathExists = false;
        Node root = findRootOfPath(node, i);
        
        if (root != null) {
            pathExists = checkIfPathExists(root, str.toCharArray(), 0);
        }
        
        return pathExists;
    }

    private static boolean checkIfPathExists(Node node, char[] charArray, int index) {
        boolean checkIfPathExists = false;
        if (node == null) {
            checkIfPathExists = (index == charArray.length);
        } else {
            Integer i = Integer.parseInt(String.valueOf(charArray[index]));
            if (node.data == i) {
                index++;
            }
            
            checkIfPathExists = checkIfPathExists(node.left, charArray, index) ||
                                    checkIfPathExists(node.right, charArray, index);
        }
        
        return checkIfPathExists;
    }

    private static Node findRootOfPath(Node node, int i) {
        if (node == null) {
            return null;
        }
        
        Node finalNode = null;
        if (node.data == i) {
            finalNode = node;
        }
        
        if (finalNode == null) {
            finalNode = findRootOfPath(node.left, i);
            
            if (finalNode == null) {
                finalNode = findRootOfPath(node.right, i);
            }
        }
        
        return finalNode;
    }

    public static void main(String[] args) throws Exception {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(90);
        tree.root.left = new Node(50);
        tree.root.right = new Node(120);
        tree.root.left.left = new Node(30);
        tree.root.left.right = new Node(80);
        tree.root.right.left = new Node(100);

        Node succ = tree.findInOrderSuccessor(tree.root, tree.root.right.left);
        System.out.println(succ.data);

        System.out.println(tree.getCountOfPossiblePathsForSum(tree.root, 170));

        int number = findPossibleMatch(tree.root, 81);

        if (number == -1) {
            Node leastDiffNode = findNextPossibleMatch(tree.root, 81, tree.root);
            System.out.println(leastDiffNode.data);
        }
        
        
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.root = new Node(90);
        tree1.root.left = new Node(50);
        tree1.root.right = new Node(120);
        tree1.root.left.left = new Node(30);
        tree1.root.left.right = new Node(80);
        tree1.root.right.left = new Node(100);
        tree1.root.right.right = new Node(130);
        
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = new Node(90);
        tree2.root.left = new Node(120);
        tree2.root.right = new Node(50);
        tree2.root.left.left = new Node(130);
        tree2.root.left.right = new Node(100);
        tree2.root.right.right = new Node(30);
        tree2.root.right.left = new Node(80);
        
        System.out.println(checkIfMirrored(tree1.root, tree2.root));
        System.out.println(checkIfMirrored(tree1.root, tree1.root));
        System.out.println(checkIfMirrored(tree2.root, tree2.root));
        
        BinarySearchTree tree3 = new BinarySearchTree();
        tree3.root = new Node(1);
        tree3.root.left = new Node(2);
        tree3.root.right = new Node(3);
        tree3.root.left.left = new Node(4);
        tree3.root.left.right = new Node(5);
        tree3.root.right.left = new Node(6);
        tree3.root.right.right = new Node(7);
        
        System.out.println(checkIfPathExists(tree3.root, "25"));
        System.out.println(checkIfPathExists(tree3.root, "136"));
    }

}

class Node {

    int data;
    Node left;
    Node right;
    public int diff;

    Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node rightChild) {
        this.right = rightChild;
    }
}