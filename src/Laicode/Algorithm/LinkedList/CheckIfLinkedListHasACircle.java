package Laicode.Algorithm.LinkedList;

/*
* Check if a given linked list has a cycle. Return true if it does, otherwise return false.



Assumption:

You can assume there is no duplicate value appear in the linked list.
* */

public class CheckIfLinkedListHasACircle {

    public boolean HasACircle(ListNode head){
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow){
                return true;
            }
        }

        return false;
    }
}

// TIME COMPLEXITY:  O(n)
// SPACE COMPLEXITY: O(1)
