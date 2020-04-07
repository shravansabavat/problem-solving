package leetcode.linkedlist;

import uottawa.winter.problems.linkedlist.Link;

public class ReorderList {
    static ListNode head = null;
    public static void reorderList(ListNode head) {

    }

    public static void main(String[] args) {
        insertAtLast(1);
        insertAtLast(2);
        insertAtLast(3);
        insertAtLast(4);
        reorderList(head);
    }

    public static void insertAtLast(int data){
        ListNode listNode = new ListNode(data);
        if(head == null){
            head = listNode;
            return;
        }

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = listNode;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


}
