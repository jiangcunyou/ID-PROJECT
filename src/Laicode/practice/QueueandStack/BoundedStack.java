package Laicode.practice.QueueandStack;

public class BoundedStack {

    public int[] array;
    private int head;

    public BoundedStack(int cap){

        array = new int[cap];
        head = -1;
    }

    public int size(){

        return head + 1;
    }

    public boolean isEmpty(){

        return size() == 0;
    }

    public boolean isFull(){

        return size() == array.length;
    }

    public boolean push(int ele){

        if (isFull()){
            return false;
        }

        array[++head] = ele;
        return true;
    }

    public Integer pop(){

        return isEmpty() ? null : array[head--];
    }

    public Integer top(){

        return isEmpty() ? null : array[head];
    }
}
