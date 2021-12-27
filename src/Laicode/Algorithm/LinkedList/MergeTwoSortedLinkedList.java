package Laicode.Algorithm.LinkedList;

/*
* Merge two sorted lists into one large sorted list.

Examples

L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
L1 = null, L2 = null, merge L1 and L2 to null
* */

public class MergeTwoSortedLinkedList {

    public ListNode merge(ListNode one, ListNode two){

        if (one == null || two == null){
            return one == null ? two : one;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode curone = one;
        ListNode curtwo = two;

        while (curone != null && curtwo != null){
            if (curone.value <= curtwo.value){
                cur.next = curone;
                curone = curone.next;
            }else {
                cur.next = curtwo;
                curtwo = curtwo.next;
            }
            cur = cur.next;
        }

        if (curone == null){
            cur.next = curtwo;
        }
        if (curtwo == null){
            cur.next = curone;
        }
        return dummy.next;
    }
}

// TIME COMPLEXITY:  O(n + m)
// SPACE COMPLEXITY: O(1)
