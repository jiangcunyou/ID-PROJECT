package Laicode.Algorithm.QueueAStack;

/*
* Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(),
* poll() and peek() operations. When the queue is empty, poll() and peek() should return null.

C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(),
* front() and pop() operations. When the queue is empty, front() should return -1.

Assumptions

The elements in the queue are all Integers.
size() should return the number of elements buffered in the queue.
isEmpty() should return true if there is no element buffered in the queue, false otherwise.
* */

import java.util.LinkedList;
import java.util.Stack;

public class QueueByTwoStacks {
    public LinkedList<Integer> s1 = new LinkedList<Integer>();
    public LinkedList<Integer> s2 = new LinkedList<Integer>();
    public void Solution(){

    }

    public void move(){
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.offerFirst(s1.pollFirst());
            }
        }
    }

    public Integer poll(){
        move();
        return s2.isEmpty() ? null : s2.pollFirst();
    }

    public void offer(int ele){
        s1.offerFirst(ele);
    }

    public Integer peek(){
        move();
        return s2.isEmpty() ? null : s2.peekFirst();
    }

    public int size(){
        return s1.size() + s2.size();
    }

    public boolean isEmpty(){
        return s1.size() == 0 && s2.size() == 0;
    }
}
