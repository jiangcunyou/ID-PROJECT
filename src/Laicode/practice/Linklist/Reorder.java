package Laicode.practice.Linklist;

public class Reorder {

    public ListNode reorder(ListNode head){
        if (head == null || head.next == null){

            return head;
        }

        ListNode mid = middle(head);
        ListNode one = head;
        ListNode two = mid.next;

        mid.next = null;

        return merge(one, reverse(two));
    }

    public ListNode middle(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null || fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
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

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null){

            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }

        if (one != null){
            cur.next = one;
        }else
            cur.next = two;

        return dummy.next;
    }
}
