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
    public ListNode reorder(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode one = head;
        ListNode two = mid.next;
        mid.next = null;

        return merge(one, reverse(two));
    }

    private ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode merge(ListNode one, ListNode two){
        ListNode res = new ListNode(0);
        ListNode dum = res;
        while(one != null && two != null){
            res.next = one;
            one = one.next;
            res.next.next = two;
            two = two.next;
            res = res.next.next;
        }
        if(one != null){
            res.next = one;
        }else if(two != null){
            res.next = two;
        }
        return dum.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ReorderLinkedList rll = new ReorderLinkedList();
        rll.reorder(n1);
        System.out.println(n1.value);
        System.out.println(n1.next.value);
        System.out.println(n1.next.next.value);
        System.out.println(n1.next.next.next.value);
    }
}



// TIME COMPLEXITY:  O(n)
// SPACE COMPLEXITY: O(1)