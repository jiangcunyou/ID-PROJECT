package Laicode.practice.Linklist;

public class Findmiddle {

    public ListNode findmid(ListNode head){

        if (head == null || head.next == null){

            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null || fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
