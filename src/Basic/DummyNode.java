package Basic;

import java.util.List;

public class DummyNode {



    public static void main(String[] args) {

        ListNode cur = new ListNode(5);
        Insert(cur, 3);

        System.out.println(cur.next.value);

    }

    public static ListNode Insert(ListNode node, int x){

        ListNode newr = new ListNode(x);
        node.next = newr;
        node = node.next;

        return node;
    }

    public static ListNode mergeLL(ListNode head1, ListNode head2){

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode cur1 = head1;
        ListNode cur2 = head2;

        while (cur1 != null && cur2 != null){

            if (cur1.value <= cur2.value){
                curr.next = cur1;
                curr = curr.next;
                cur1 = cur1.next;

            }else {
                curr.next = cur2;
                curr = curr.next;
                cur2 = cur2.next;
            }
        }

        if (cur1 == null){
            curr.next = cur2;
        }

        if (cur2 == null){
            curr.next = cur1;
        }

        return dummy.next;
    }
}

class ListNode{

    public int value;
    public ListNode next;

    public ListNode(int x){
        this.value = x;
    }

}
