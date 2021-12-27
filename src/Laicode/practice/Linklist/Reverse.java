package Laicode.practice.Linklist;

public class Reverse {

    /*
    * Iterative way
    * */

    public ListNode reverseLinklist(ListNode head){

        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode next = null;

        while (head != null){

            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    /*
    * Recursive way
    * */

    public ListNode reverse(ListNode head){

        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        ListNode newlist = new ListNode(5);
        ListNode next1 = new ListNode(6);
        ListNode next2 = new ListNode(7);


        newlist.next = next1;
        next1.next = next2;


        System.out.println(newlist.value);
        System.out.println(newlist.next.value);
        System.out.println(newlist.next.next.value);


        Reverse re = new Reverse();

        ListNode result =  re.reverse(newlist);
        System.out.println(result.value);
        System.out.println(result.next.value);
        System.out.println(result.next.next.value);


    }
}
