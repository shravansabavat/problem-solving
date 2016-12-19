package uottawa.winter.problems.binarytree;

import java.util.LinkedList;

public class StackLinkedList {

    LinkedList ll = new LinkedList();

    public void push(String str) {
        ll.addFirst(str);
    }

    public String pop() {
        return (String) ll.removeFirst();
    }

    public static void main(String[] args) {
        StackLinkedList sll = new StackLinkedList();

        sll.push("s");
        sll.push("shravan");
        sll.push("kumar");
        sll.push("sabavat");

        System.out.println(sll.pop());
        System.out.println(sll.pop());
        System.out.println(sll.pop());
        System.out.println(sll.pop());
    }

}
