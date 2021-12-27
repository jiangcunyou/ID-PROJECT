package Laicode.practice.Linklist;

public class Removelements {

    public ListNode removeelements(ListNode head, int target){

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null){

            if (head.value == target){

                prev.next = head.next;
            }else {

                prev = head;
            }

            head = head.next;
        }

        return dummy.next;
    }
}
