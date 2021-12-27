package Laicode.Algorithm.LinkedList;

/*
* Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes
* larger than or equal to target value T. The original relative order of the nodes in each of the two partitions
* should be preserved.

Examples

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
* */

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target){
        if (head == null || head.next == null){
            return head;
        }

        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode cursmall = small;
        ListNode curlarge = large;

        while (head.next != null){
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

// TIME COMPLEXITY:  O(n)
// SPACE COMPLEXITY: O(1)