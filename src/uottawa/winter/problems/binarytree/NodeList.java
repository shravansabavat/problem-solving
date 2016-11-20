package uottawa.winter.problems.binarytree;

import java.util.ArrayList;
import java.util.Collections;

public class NodeList extends ArrayList {
	
	public boolean add(NodeListNode n){
		boolean added = super.add(n);
		NodeListNode curr = n;
	    for (int i = size() - 1, j = i -1; i > 0; i--, j--) {
	    	NodeListNode ni = (NodeListNode) get(i);
	    	NodeListNode nj = (NodeListNode) get(j);
	        if (ni.getValue() > nj.getValue()) continue;
	        else Collections.swap(this, i, j);
	        
	    }
	    return added;
	}
	
	public static int[] sortArray(int[] arr) {
		for (int i = arr.length - 1, j = i -1; i > 0; i--, j--) {
			int valueI = arr[i];
			int valueJ = arr[j];
			if (valueI > valueJ) {
				continue;
			}
			else  {
				arr = swap(arr, i, j);
			}
		}
		
		return arr;
	}
	
	private static int[] swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void main(String[] args) {
		NodeList ll = new NodeList();
		ll.add(new NodeListNode(4));
		ll.add(new NodeListNode(1));
		ll.add(new NodeListNode(3));
		ll.add(new NodeListNode(2));
		ll.add(new NodeListNode(0));
		ll.add(new NodeListNode(5));
		ll.add(new NodeListNode(10));
		
//		for (Object o : ll) {
//			NodeListNode n = (NodeListNode)o;
//			System.out.println(n.getValue());
//		}
		
		int[] arr = {4, 1, 3, 2, 0, 5, 10};
		
		arr = sortArray(arr);
		for (int num : arr) {
			System.out.println(num);
		}
	}
	
}
