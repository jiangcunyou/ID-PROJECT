package Laicode.Algorithm.LinkedList;

/*
* Given a linked list, check whether it is a palindrome.

Examples:

Input:   1 -> 2 -> 3 -> 2 -> 1 -> null

output: true.

Input:   1 -> 2 -> 3 -> null

output: false.

Requirements:

Space complexity must be O(1)
* */

import java.util.List;

public class CheckIfLinkedListIsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null){
            return true;
        }
        ListNode mid = findMid(head);
        ListNode right = reverse(mid.next);
        while (right != null){
            if (right.value == head.value){
                right = right.next;
                head = head.next;
            }else {
                return false;
            }
        }
        return true;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;

        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        boolean l = isPalindrome(l1);
    }
}

// TIME COMPLEXITY:  O(n)
// SPACE COMPLEXITY: O(1)