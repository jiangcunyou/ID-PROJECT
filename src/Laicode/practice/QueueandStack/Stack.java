package Laicode.practice.QueueandStack;

import Laicode.practice.Linklist.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Stack {

    private ListNode head;
    private int size;

    public Integer pop(){

        if (head == null){

            return null;
        }

        ListNode res = head;
        head = head.next;
        res.next = null;
        size--;

        return res.value;
    }

    public Integer peek(){

        if (head == null){
            return null;
        }

        return head.value;
    }

    public boolean push(int ele){

        ListNode node = new ListNode(ele);
        node.next = head;
        head = node;
        size++;

        return true;
    }

    public int size(){

        return size;
    }

    public boolean isEmpty(){

        return size == 0;
    }

    public static void main(String[] args) {
        Deque s = new LinkedList();

    }

}
