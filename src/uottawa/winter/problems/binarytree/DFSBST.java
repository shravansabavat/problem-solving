package uottawa.winter.problems.binarytree;

import java.util.LinkedList;
import java.util.Queue;


public class DFSBST {

	Node root;

	public Node createBTNode(Node root, int data){
		if(root == null) {
			root = new Node(data);
			return root;
		} else if(root.getData() <= data) {
			root.left = createBTNode(root.getLeft(), data);
		} else if(root.getData() > data) {
			root.right = createBTNode(root.getRight(), data);
		} 
		return root;
	}

	public static void main(String[] args) {
		String[] inputNodes = "5 3 8 1 4 6 9".split(" ");
		DFSBST bst = new DFSBST();

		for(String nodeValue : inputNodes){
			Integer node = Integer.parseInt(nodeValue);
			bst.root = bst.createBTNode(bst.root, node);
		}


		printDFSOrder(bst.root);
		System.out.println();
		printBFSOrder(bst.root);
	}

	public static void printDFSOrder(Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.data);
		printDFSOrder(root.getRight());
		printDFSOrder(root.getLeft());
	}

	public static void printBFSOrder(Node root) {
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(root);

		while(nodes.isEmpty() == false) {
			Node node = nodes.poll();
			System.out.print(node.data);
			if (node.right != null) {
				nodes.add(node.getRight());
			}
			if(node.left != null) {
				nodes.add(node.getLeft());
			}
		}

	}

}