package Laicode.Algorithm.LinkedList;

/*
* Reverse a singly-linked list recursively.

Examples

L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null

* */

public class ReversedLinkedListRecursive {
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode curNode = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return curNode;
    }
}

// TIME COMPLEXITY:  O(n)
// SPACE COMPLEXITY: O(n)

