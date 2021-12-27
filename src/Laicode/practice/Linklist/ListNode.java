package Laicode.practice.Linklist;

import java.util.LinkedList;
import java.util.List;

public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value){

        this.value = value;
        this.next = null;
    }

    public int length(ListNode head){

        int length = 0;

        while (head.next != null){

            length++;
            head = head.next;
        }

        return length;
    }

    public ListNode get(ListNode head, int index){

        while (index > 0 && head != null){
            index--;
            head = head.next;
        }

        return head;
    }

    public ListNode appendhead(ListNode head, int value){

        ListNode newHead = new ListNode(value);
        newHead.next = head;

        return newHead;
    }

    public ListNode appendtail(ListNode head, int value){

        if(head == null)
            return new ListNode(value);

        ListNode prev = head;
        while(prev.next != null){

            prev = prev.next;
        }

        prev.next = new ListNode(value);

        return head;
    }

    public ListNode remove(ListNode head, int value){

        if (head == null)
            return null;
        else if (head.value == value)
            return head.next;

        ListNode cur = head;
        while (cur.next != null && cur.next.value != value){
            cur = cur.next;
        }

        if (cur.next != null){
            cur.next = cur.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList();

        System.out.println(list.size());

        list.add(1);
        list.add(0,2 );
        list.add(1,3);

        System.out.println(list.get(1));
        list.remove(1);

        System.out.println(list.set(0,4));
        System.out.println(list);

        System.out.println(list.size());

    }
}
