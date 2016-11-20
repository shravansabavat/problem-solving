package uottawa.winter.problems.binarytree;


public class SortArrayList {
	
	public static void main(String[] args) {
		
		NodeList list = new NodeList();
		list.add(new NodeListNode(4));
		list.add(new NodeListNode(3));
		list.add(new NodeListNode(2));
		list.add(new NodeListNode(1));
		list.add(new NodeListNode(5));
		list.add(new NodeListNode(10));
		
		
		for(Object node : list) {
			NodeListNode n = (NodeListNode) node;
			System.out.println(n.value);
		}
	}
	
	

}





