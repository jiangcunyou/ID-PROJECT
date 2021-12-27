package Laicode.practice.Linklist;

public class Partition {

    public ListNode partition(ListNode head, int target){

        if (head == null || head.next == null){

            return head;
        }

        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode cursmall = small;
        ListNode curlarge = large;

        while (head != null){

            if (head.value < target){
                cursmall.next = head;
                cursmall = cursmall.next;
            }else {
                curlarge.next = head;
                curlarge = curlarge.next;
            }

            head = head.next;
        }

        cursmall.next = large.next;
        curlarge.next = null;

        return small.next;
    }
}
