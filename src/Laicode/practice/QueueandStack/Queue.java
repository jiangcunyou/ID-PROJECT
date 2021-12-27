package Laicode.practice.QueueandStack;

import Laicode.practice.Linklist.ListNode;

public class Queue {

    private ListNode head;
    private ListNode tail;
    private int size;

    public Queue(){

    }

    public Integer poll(){

        if (head == null)
            return null;

        ListNode node = head;
        head = head.next;

        if (head == null){
            tail = null;
        }

        node.next = null;
        size--;

        return node.value;
    }

    public Integer peek(){

        if (head == null){
            return null;
        }

        return head.value;
    }

    public boolean offer(Integer ele){

        if (head == null){

            head = new ListNode(ele);
            tail = head;
        }else {
            tail.next = new ListNode(ele);
            tail = tail.next;
        }

        size++;
        return true;
    }

    public int size(){

        return size;
    }

    public boolean isEmpty(){

        return size == 0;
    }
}
