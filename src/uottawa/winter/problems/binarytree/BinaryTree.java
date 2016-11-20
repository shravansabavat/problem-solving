package uottawa.winter.problems.binarytree;

public class BinaryTree {
	
	Node root;
	
	static Node first = null, last = null, prev = null;
	
	public BinaryTree(int value) {
		this.root.data = value;
	}
	
	public static Node createBTNode(Node root, int val) {
		
		if (root == null) {
			root = new Node(val);
		} else if (root.left == null) {
			root.left = createBTNode(root.left, val);
		} else if (root.right == null) {
			root.right = createBTNode(root.right, val);
		}
		
		return root;
	}
	
	public static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data);
		inOrder(root.right);
	}
	
	public static boolean isSubTree(Node original, Node virtual) {
	    
	    String pretree1 = stringFromPreOrder(original);
	    String pretree2 = stringFromPreOrder(virtual);
	    
	    System.out.println(pretree1);
	    System.out.println(pretree2);
	    
	    String intree1 = stringFromInOrder(original);
        String intree2 = stringFromInOrder(virtual);
        
        System.out.println(intree1);
        System.out.println(intree2);
	    
        return pretree1.indexOf(pretree2) > -1 && intree1.indexOf(intree2) > -1;
	}
	
	public static String stringFromPreOrder(Node node) {
	    if (node == null) {
	        return "";
	    }
	    
	    return node.data + stringFromPreOrder(node.left) + stringFromPreOrder(node.right);
	}
	
	public static String stringFromInOrder(Node node) {
        if (node == null) {
            return "";
        }
        
        return stringFromPreOrder(node.left) + node.data + stringFromPreOrder(node.right);
    }
	
	public static void main(String[] args) {
		
//		String[] inputNodes = "5 6 8 1 3 2 10".split(" ");
//		BinaryTree bt = new BinaryTree();
//		Node btNode = bt.root;
//		
//		for(String nodeValue : inputNodes){
//			Integer node = Integer.parseInt(nodeValue);
//			btNode = createBTNode(btNode, node);
//		}
		
//		Node root = new Node(3);
//		Node n1 = new Node(5);
//		Node n2 = new Node(6);
//		Node n3 = new Node(2);
//		Node n4 = new Node(8);
//
//		root.left = n1;
//		root.right = n2;
//		root.right.left = n3;
//		root.right.right = n4;
//		
////		inOrder(root);
////		recoverToBst(root);
////		System.out.println();;
////		inOrder(root);
//		
//		Node root2 = root;
	    
	    Node root1 = new Node(1);
        Node n1 = new Node(2);
        root1.left = n1;
        
        Node root2 = new Node(1);
        Node n22 = new Node(2);
        Node n32 = new Node(1);
        root2.left = n22;
        root2.right = n32;
        
//        Node n2 = new Node(3);
//        Node n3 = new Node(2);
//        Node n4 = new Node(8);
//        
//        Node root2 = root1;
//		
		System.out.println(isSubTree(root1, root2));
//		System.out.println(isSubTree(root1, n1));
//		System.out.println(isSubTree(root1, n2));
//		System.out.println(isSubTree(root1, n3));
//		System.out.println(isSubTree(root1, n4));
//		
//		System.out.println(isSubTree(n4, root1));
//		System.out.println(isSubTree(n3, root1));
//		System.out.println(isSubTree(n2, root1));
//		System.out.println(isSubTree(n1, root1));
	}
	
	public static void recoverToBst(Node root) {
		findSegments(root);
		int temp = first.data;
		first.data = last.data;
		last.data = temp;
	}
	
	public static void findSegments(Node root) {
		
		if (root == null) {
			return;
		}
		
		findSegments(root.left);
		
		if (prev != null) {
			if (prev.data > root.data) {
				if (first == null) {
					first = root;
				}
				last = root;
			}
		}
		
		prev = root;
		findSegments(root.right);
	}

}
