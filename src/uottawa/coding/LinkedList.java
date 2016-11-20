package uottawa.coding;

import uottawa.winter.problems.linkedlist.Link;
import uottawa.winter.problems.linkedlist.MyLinkedList;

public class LinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(2);
        list.insertAtLast(1);
        list.insertAtLast(5);
        System.out.println(isPallindrome(list));
        
        list.tail.nextlink = list.head;
    }
    
    private static boolean doesLoopExists(Link head) {
        Link slow = head, fast = head;
        while (slow != null && fast.nextlink != null) {
            
        }
        
        return false;
    }

    private static boolean isPallindrome(MyLinkedList list) {
        Link reverseHead = reverseLink(list.head);
        return areEqual(list.head, reverseHead);
    }

    private static boolean areEqual(Link head, Link reverseHead) {
        while (head != null && reverseHead != null) {
            if (head.data != reverseHead.data) {
                return false;
            }
            head = head.nextlink;
            reverseHead = reverseHead.nextlink;
        }
        return head == null && reverseHead == null;
    }
    
    public static Link findIntersection(Link link1, Link link2) {
        int link1Length = findSize(link1);
        int link2Length = findSize(link2);
        
        boolean link1Bigger = link1Length > link2Length ? true : false;
        int offset = link1Bigger ? link1Length - link2Length : link2Length - link1Length;
        
        if (offset > 0) {
            if (link1Bigger) {
                
            } else {
                
            }
        }
        
        
        return null;
    }
    
    public static Link addLists(Link link1, Link link2) {
        return addNumbers(link1, link2, 0);
    }
    
    private static Link addNumbers(Link link1, Link link2, int carry) {
        if (link1 == null && link2 == null && carry == 0) {
            return null;
        }
        
        int value = carry;
        if (link1 != null) {
            value += link1.data;
        }
        
        if (link2 != null) {
            value += link2.data;
        }
        
        int result = value % 10;
        Link link = new Link(result);
        
        if (link1 != null || link2 != null) {
            link.nextlink = addNumbers(link1 == null ? null : link1.nextlink, link2 == null ? null : link2.nextlink, value > 10 ? 1 : 0);
        }
        
        return link;
    }

    public static int findSize(Link node) {
        int length = 0;
        while(node != null) {
            length++;
            node = node.nextlink;
        }
        
        return length;
    }

    private static Link reverseLink(Link node) {
        Link head = null;

        while(node != null) {
            Link link = new Link(node.data);
            link.nextlink = head;
            head = link;

            node = node.nextlink;
        }
        return head;
    }

}
