package Laicode.Algorithm.LinkedList;

/*
* Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

Examples

L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
* */

public class ReorderLinkedList{
    public ListNode reorder(ListNode head){

        if (head == null || head.next == null){
            return head;
        }

        ListNode mid = middleNode(head);
        ListNode one  = head;
        ListNode two = mid.next;

        mid.next = null;

        return merge(one, reverse(two));
    }

    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;

        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode merge(ListNode one, ListNode two){

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (one != null && two != null){
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }

        if(one != null){
            cur.next = one;
        }else{
            cur.next = two;
        }
        return dummy.next;
    }
}



// TIME COMPLEXITY:  O(n)
// SPACE COMPLEXITY: O(1)