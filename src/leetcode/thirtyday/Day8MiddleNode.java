package leetcode.thirtyday;

public class Day8MiddleNode {
    public static ListNode middleNode(ListNode head) {
        ListNode curr = head;
        ListNode middle = head;

        int size = 0;
        while(curr != null) {
            size++;
            curr = curr.next;
            if (size % 2 == 0) {
                middle = middle.next;
            }

        }

        return middle;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        System.out.println(middleNode(head).val);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
