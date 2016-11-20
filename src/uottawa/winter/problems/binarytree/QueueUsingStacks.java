package uottawa.winter.problems.binarytree;

import java.util.Stack;

public class QueueUsingStacks<E> {

	Stack<E> inbox = new Stack<E>();
	Stack<E> outbox = new Stack<E>();

	public void queue(E item) {
		inbox.push(item);
	}

	public E dequeue() {
		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		
		return outbox.pop();
	}
	
	public static void main(String[] args) {
		QueueUsingStacks<String> qus = new QueueUsingStacks<String>();
		qus.queue("shravan");
		qus.queue("kumar");
		qus.queue("sabavat");
		
		System.out.println(qus.dequeue());
		System.out.println(qus.dequeue());
		System.out.println(qus.dequeue());
	}

}
