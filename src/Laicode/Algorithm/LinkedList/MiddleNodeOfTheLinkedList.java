package Laicode.Algorithm.LinkedList;

/*
* Find the middle node of a given linked list.

Examples

L = null, return null
L = 1 -> null, return 1
L = 1 -> 2 -> null, return 1
L = 1 -> 2 -> 3 -> null, return 2
L = 1 -> 2 -> 3 -> 4 -> null, return 2
* */

public class MiddleNodeOfTheLinkedList {

    public ListNode findMiddle(ListNode head){
        if (head == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

// TIME COMPLEXITY:  O(n)
// SPACE COMPLEXITY: O(1)
