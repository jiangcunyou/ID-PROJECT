package Laicode.Algorithm.QueueAStack;

/*
* Java: Implement a deque by using three stacks. The queue should provide size(), isEmpty(), offerFirst(),
* offerLast(), pollFirst(), pollLast(), peekFirst() and peekLast() operations. When the queue is empty,
* pollFirst(), pollLast(), peekFirst() and peek() should return null.
* */

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks {

    private Deque<Integer> left = new ArrayDeque<>();
    private Deque<Integer> right = new ArrayDeque<>();
    private Deque<Integer> buffer = new ArrayDeque<>();

    public void Solution() {
        // Write your solution here.
    }

    public void offerFirst(int element) {
        left.offerFirst(element);
    }

    public void offerLast(int element) {
        right.offerFirst(element);
    }

    public Integer pollFirst() {
        move(right, left);
        return left.isEmpty() ? null : left.pollFirst();
    }

    public Integer pollLast() {
        move(left, right);
        return right.isEmpty() ? null : right.pollFirst();
    }

    public Integer peekFirst() {
        move(right, left);
        return left.isEmpty() ? null : left.peekFirst();
    }

    public Integer peekLast() {
        move(left, right);
        return right.isEmpty() ? null : right.peekFirst();
    }

    public int size() {

        return left.size() + right.size();
    }

    public boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    public void move(Deque<Integer> left, Deque<Integer> right){
        if (!right.isEmpty()){
            return;
        }
        int half = left.size() / 2;
        for (int i = 0; i < half; i++) {
            buffer.offerFirst(left.pollFirst());
        }
        while (!left.isEmpty()){
            right.offerFirst(left.pollFirst());
        }
        while (!buffer.isEmpty()){
            left.offerFirst(buffer.pollFirst());
        }
    }
}
