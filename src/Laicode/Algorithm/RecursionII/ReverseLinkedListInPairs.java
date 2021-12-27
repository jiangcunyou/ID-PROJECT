package Laicode.Algorithm.RecursionII;

/*
* Reverse pairs of elements in a singly-linked list.

Examples

L = null, after reverse is null
L = 1 -> null, after reverse is 1 -> null
L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null

* */

class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value) {
    this.value = value;
    next = null;
  }
}

public class ReverseLinkedListInPairs {
    //Recursion way
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = head.next;
        head.next = reverseInPairs(head.next.next);
        newhead.next = head;
        return newhead;
    }
    //Time  complexity:  O(n)
    //Space complexity:  O(n)

    //Iterative way
    public ListNode reverseInPairsII(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            ListNode next = cur.next.next;
            cur.next.next = cur.next.next.next;
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }
    //Time  complexity:  O(n)
    //Space complexity:  O(1)
}
