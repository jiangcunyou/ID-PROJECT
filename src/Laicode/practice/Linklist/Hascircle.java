package Laicode.practice.Linklist;

public class Hascircle {

    public boolean hascircle(ListNode head){

        if (head == null || head.next == null){

            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null || fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow){
                return true;
            }
        }

        return false;
    }
}
