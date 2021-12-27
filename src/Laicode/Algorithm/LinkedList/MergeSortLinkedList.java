package Laicode.Algorithm.LinkedList;

/*
* Given a singly-linked list, where each node contains an integer value, sort it in ascending order.
* The merge sort algorithm should be used to solve this problem.

Examples

null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
* */

public class MergeSortLinkedList {
    public ListNode mergeSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null){
            return head;
        }

        ListNode mid = findmid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(midNext);

        return merge(left, right);
    }

    public ListNode findmid(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode merge(ListNode left, ListNode right){

        ListNode res = null;
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }

        if (left.value <= right.value){
            res = left;
            res.next = merge(left.next, right);
        }else {
            res = right;
            res.next = merge(left, right.next);
        }
        return res;
    }
}

//Time Complexity:  O(nlog n)
//Space Complexity: O(nlog n)