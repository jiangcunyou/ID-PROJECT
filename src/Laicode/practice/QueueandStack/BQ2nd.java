package Laicode.practice.QueueandStack;

public class BQ2nd {

    private int head;
    private int tail;
    private int[] array;

    public BQ2nd(int cap){

        array = new int[cap + 1];
        head = 0;
        tail = 1;
    }

    public boolean isFull(){

        return head == tail;
    }

    public boolean isEmpty(){

        return (head + 1) % array.length == tail;
    }

    public int size(){

        int size = tail - head - 1;
        return size < 0 ? array.length + size : size;
    }

    public boolean offer(int ele){
        if (isFull()){
            return false;
        }

        array[tail] = ele;
        tail = tail + 1 == array.length ? 0: tail + 1;

        return true;
    }

    public Integer peek(){

        return isEmpty() ? null : array[(head + 1) % array.length];
    }

    public Integer poll(){

        return isEmpty() ? null : array[head = (head + 1) % array.length];
    }
}
