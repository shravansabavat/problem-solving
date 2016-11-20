package uottawa.winter.problems.binarytree;

import java.util.Queue;

public class BSTValidation {

	public static int[] sortedArray = new int[7];

	public static int count = 0;

	public static Node prev;

	public static void main(String[] args){

		//			10
		//		5			13
		//	4		6	12		14
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(13);

		root.left.left = new Node(4);
		root.left.right = new Node(6);

		root.right.left = new Node(11);
		root.right.right = new Node(15);

		/*if(isValidBST(root)){
			System.out.println("valid");
		}else{
			System.out.println("not valid");
		}*/
		
		if(isValidBST(root)){
			prev = null;
			System.out.println("valid");
		}else{
			System.out.println("not valid");
		}
		
		if(isValidBSTWithOutSpace(root)){
			prev = null;
			System.out.println("valid");
		}else{
			System.out.println("not valid");
		}
		
		//breadthFirstNonRecursive(root);

	}

	private static boolean isValidBST(Node root) {
		inOrderTraversal(root);
		return checkIfSorted();
	}

	private static boolean checkIfSorted() {
		boolean sorted = true;
		for(int sortedIndex = 0; sortedIndex < sortedArray.length; sortedIndex++){
			if(!(sortedIndex + 1 == sortedArray.length)){
				if(sortedArray[sortedIndex] > sortedArray[sortedIndex +1]){
					sorted = false;
				}
			}
		}

		return sorted;
	}

	private static void inOrderTraversal(Node root) {

		if(root == null){
			return;
		}else{
			inOrderTraversal(root.left);
			sortedArray[count++] = root.data;
			inOrderTraversal(root.right);
		}

	}

	public static boolean isValidBSTWithOutSpace(Node root) {
		boolean right = true;
		boolean left = true;
		boolean rootVal = true;
		
		if(root == null){
			return true;
		}
		left = isValidBSTWithOutSpace(root.left);
		if(prev != null && prev.data > root.data){
			rootVal = false;
		}
		prev = root;
		right = isValidBSTWithOutSpace(root.right);
		
		return right && left && rootVal;
	}
	
	public boolean isValidBST1(Node root) {
		boolean leftBstValid = true;
		boolean rightBstValid = true;
		boolean rootValid = true;
		
		if (root == null) {
			return true;
		}
		
		leftBstValid = isValidBST(root.left);
		if (prev != null && prev.data > root.data) {
			rootValid = false;
		}
		prev = root;
		rightBstValid = isValidBST(root.right);
		
		return leftBstValid && rootValid && rightBstValid;
	}
	
	
	public static void breadthFirstNonRecursive(Node root) {
	    Queue<Node> queue = new java.util.LinkedList<Node>();
	    
	    if (root == null) {
	    	return;
	    }
	    
	    queue.add(root);
	    
	    while (!queue.isEmpty()) {
	        Node node = queue.remove();
	        System.out.println(node.data);
	        if (node.left != null)
	            queue.add(node.left);
	        if (node.right != null)
	            queue.add(node.right);
	    }
	}

}
