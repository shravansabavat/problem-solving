package uottawa.winter.problems.linkedlist;


public class MyLinkedList {

	public Link head;
	public Link tail;

	public MyLinkedList(){
		head = null;
		tail = null;
	}

	public void insertAtFirst(int data){
		Link addLink = new Link(data);
		Link temp = head;
		addLink.nextlink = temp;
		this.head = addLink;
	}

	public void insertAtLast(int data){
		Link addLink = new Link(data);
		if(head == null){
			head = addLink;
			tail = addLink;
		}else{
			Link temp = tail;
			temp.nextlink = addLink;
			tail = addLink;
		}
	}

	public void insertAfter(int after, int data){

		Link currLink = head;
		while(currLink != null){

			if(currLink.data == after){
				break;
			}else{
				currLink = currLink.nextlink;
			}
		}
		Link addLink = new Link(data);
		Link temp = currLink.nextlink;
		currLink.nextlink = addLink;
		addLink.nextlink = temp;
	}

	public void sortList(MyLinkedList sortList){
		Link currLink = sortList.head;
		Link startingPoint = sortList.head;
		Link newHead = null;
		//5 6 7 1 2 3 4
		while(currLink.nextlink != null){
			if(startingPoint.data < currLink.nextlink.data){
				currLink = currLink.nextlink;
			}else{
				currLink = currLink.nextlink;
				newHead = currLink;
				while(currLink.nextlink != null){
					currLink = currLink.nextlink;
				}
				currLink.nextlink = startingPoint;
				sortList.head = newHead;
				setLastLink(startingPoint);
				break;
			}
		}
	}
	public Link MergeSort(Link headOriginal) 
	{ 
		if (headOriginal == null || headOriginal.nextlink == null) 
			return headOriginal; 
		Link a = headOriginal;
		Link b = headOriginal.nextlink; 
		while ((b != null) && (b.nextlink != null)) { 
			headOriginal = headOriginal.nextlink; 
			b = (b.nextlink).nextlink; 
		} 
		b = headOriginal.nextlink; 
		headOriginal.nextlink = null; 
		return merge(MergeSort(a), MergeSort(b));

	}    

	public Link merge(Link a, Link b) 
	{ 
		Link temp = new Link(); 
		Link head = temp;
		Link c = head; 
		while ((a != null) && (b != null)) 
		{
			if (a.data <= b.data) 
			{ 
				c.nextlink = a; 
				c = a; 
				a = a.nextlink; 
			} 
			else
			{ 
				c.nextlink = b; 
				c = b; 
				b = b.nextlink;
			} 
		}
		c.nextlink = (a == null) ? b : a; 
		return head.nextlink; 
	} 

	public Link reverseWithRecursion(Link list){

		if(list == null){
			return null;
		} 
		if(list.nextlink == null){
			return list;
		}
		Link seconNum = list.nextlink;
		list.nextlink = null;
		Link reverLink = reverseWithRecursion(seconNum);
		seconNum.nextlink = list;
		return reverLink;
	}

	public Link reverse(Link link) {
		if (link == null) {
			return null;
		}

		if (link.nextlink == null) {
			return link;
		}

		Link secondLink = link.nextlink;

		link.nextlink = null;

		Link reverseRest = reverse(secondLink);

		secondLink.nextlink = link;

		return reverseRest;
	}

	public Link reverseWithOutRecursion(Link head) {

		Link previous = null, temp = null;
		while(null != head){
			temp = head.nextlink;
			head.nextlink = previous;
			previous = head;
			if(temp == null){
				break;
			}
			head = temp;
		}
		return head;
	}

	private void setLastLink(Link startingPoint) {
		while(startingPoint.nextlink != null){
			if(startingPoint.data < startingPoint.nextlink.data){
				startingPoint = startingPoint.nextlink;
			}else{
				startingPoint.nextlink = null;
			}
		}
	}

	public static Link middleNode(Link startingPoint){

		Link middle = startingPoint;
		int length = 0;
		while(null != startingPoint){
			startingPoint = startingPoint.nextlink;
			length++;
			if(length % 2 == 0){
				middle = middle.nextlink;
			}
		}
		return middle;

	}

	public int solution(int M) {
		// write your code in Java SE 8
		Link temp = head;
		long size = 0;
		if(head == null){
			return -1;
		}
		while(null != temp){
			temp = temp.nextlink;
			size++;
		}
		if(M > size){
			return -1;
		}
		long lastIndex = size - M; 
		temp = head;
		for(int index = 0; index < lastIndex;index++){
			temp = temp.nextlink;
		}
		return temp.data;
	}

	public boolean detectLoop(Link link) {
		if (link == null) {
			return false;
		}

		Link slow, fast;
		slow = fast = link;

		while(true) {
			slow = slow.nextlink;

			if (fast.nextlink != null) {
				fast = fast.nextlink;
			} else {
				return false;
			}

			if (slow == null || fast == null) {
				return false;
			}

			if (slow == fast) {
				return true;
			}
		}
	}


	public static void main(String args[]){
		//		MyLinkedList list = new MyLinkedList();
		//		list.insertAtLast(1);
		//		list.insertAtLast(2);
		//		list.insertAtLast(3);
		//		list.insertAtLast(4);
		//		list.insertAtLast(5);
		//		list.insertAtLast(6);
		//		list.insertAtLast(7);
		//		
		//		//System.out.println(list.solution(2));
		//
		//		//printLinkedList(list.head);
		//		Link reverseWithOutRecursion = list.reverseWithOutRecursion(list.head);
		//printLinkedList(reverseWithOutRecursion);

		/*list = new MyLinkedList();
		list.insertAtLast(1);
		list.insertAtLast(2);
		list.insertAtLast(3);
		list.insertAtLast(4);
		list.insertAtLast(5);
		list.insertAtLast(6);
		list.insertAtLast(7);
		printLinkedList(list.head);
		Link reverseWithRecursion = list.reverseWithRecursion(list.head);
		printLinkedList(reverseWithRecursion);


		MyLinkedList lastList = new MyLinkedList();
		lastList.insertAtLast(1);
		lastList.insertAtLast(2);
		lastList.insertAtLast(3);
		lastList.insertAtLast(4);
		lastList.insertAtLast(5);
		lastList.insertAfter(3, 6);*/

		MyLinkedList sortList = new MyLinkedList();
		sortList.insertAtFirst(5);
		sortList.insertAtFirst(2);
		sortList.insertAtFirst(1);
		sortList.insertAtFirst(3);
		Link result = sortList.MergeSort(sortList.head);
		sortList.printLinkedList(result);
	}

	public static void printLinkedList(Link link){
		Link tmp = null;
		tmp = link;
		while(tmp != null){
			System.out.println(tmp.data);
			tmp = tmp.nextlink;
		}
	}
}
