package Laicode.practice.QueueandStack;

import java.util.Random;

public class BoundedQueue {

    private int head;
    private int tail;
    private int size;
    private int[] array;

    public BoundedQueue(int cap){

        array = new int[cap];
    }

    public boolean offer(int ele){

        if (isFull()){
            return false;
        }

        array[tail] = ele;
        tail = tail + 1 == array.length ? 0 : tail + 1;
        size++;

        return true;
    }

    public Integer peek(){

        return isEmpty() ? null : array[head];
    }

    public Integer poll(){

        if (isEmpty()){

            return null;
        }

        int result = array[head];
        head = head + 1 == array.length ? 0 : head + 1;
        size--;
        return result;
    }

    public int size(){

        return size;
    }

    public boolean isEmpty(){

        return size == 0;
    }

    public boolean isFull(){

        return size == array.length;
    }

    public static void main(String[] args) {

        Random r = new Random();
        int result = r.nextInt(5) + 5;

        System.out.println(result);
    }
}
