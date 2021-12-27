package Laicode.Algorithm.LinkedList;

/*
* Reverse a singly-linked list iteratively.

Examples

L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
* */





public class ReversedLinkedListIterative {
    public static ListNode reverse(ListNode head){

        if(head == null || head.next == null){
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

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(7);


        l1.next = l2;
        l2.next = l3;


        reverse(l1);

        System.out.println(l3.value);
        System.out.println(l3.next.value);
        System.out.println(l3.next.next.value);

    }
}

// TIME COMPLEXITY:  O(n)
// SPACE COMPLEXITY: O(1)


