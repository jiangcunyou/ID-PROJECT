package Laicode.Algorithm.QueueAStack;

/*
* Enhance the stack implementation to support min() operation.
* min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.

push(int element) - push the element to top
pop() - return the top element and remove it, if the stack is empty, return -1
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.
* */

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minstack;

    public StackWithMin(){
        stack = new LinkedList<>();
        minstack = new LinkedList<>();
    }

    public int min(){
        if (minstack.isEmpty()){
            return -1;
        }
        return minstack.peekFirst();
    }

    public void push(int value){
        stack.offerFirst(value);
        if (minstack.isEmpty() || value <= minstack.peekFirst()){
            minstack.offerFirst(value);
        }
    }

    public int pop(){
        if (stack.isEmpty()){
            return -1;
        }
        Integer result = stack.pollFirst();
        if (minstack.peekFirst().equals(result)){
            minstack.pollFirst();
        }
        return result;
    }

    public int top(){
        if (stack.isEmpty()){
            return -1;
        }
        return stack.peekFirst();
    }
}
