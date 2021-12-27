package Laicode.Algorithm.QueueAStack;

/*
* Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).

After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

Assumptions:

The given stack is not null.
There can be duplicated numbers in the give stack.
Requirements:

No additional memory, time complexity = O(n ^ 2).
* */

import java.util.Deque;
import java.util.LinkedList;

public class SortWithTwoStacks {
    public void sort(LinkedList<Integer> s1) {
        // Write your solution here.
        if (s1 == null || s1.size() <= 1){
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        sort(s1, s2);
    }

    private void sort(Deque<Integer> input, Deque<Integer> buffer){
        while(!input.isEmpty()){
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while (!input.isEmpty()){
                int cur = input.pollFirst();
                if (cur < curMin){
                    curMin = cur;
                    count = 1;
                }else if (cur == curMin){
                    count++;
                }
                buffer.offerFirst(cur);
            }
            while (!buffer.isEmpty() && buffer.peekFirst() >= curMin){
                int tmp = buffer.pollFirst();
                if (tmp != curMin){
                    input.offerFirst(tmp);
                }
            }
            while (count-- > 0){
                buffer.offerFirst(curMin);
            }
        }

        while (!buffer.isEmpty()){
            input.offerFirst(buffer.pollFirst());
        }
    }

    private void s(Deque<Integer> input, Deque<Integer> buffer){
        while (!input.isEmpty()){
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while (!input.isEmpty()){
                int cur = input.pollFirst();
                if (cur < curMin){
                    cur = curMin;
                    count = 1;
                }else if (cur == curMin){
                    count++;
                }
                buffer.offerFirst(cur);
            }

            while (!buffer.isEmpty() && buffer.peekFirst() >= curMin){
                int tmp = buffer.pollFirst();
                if (tmp != curMin){
                    input.offerFirst(tmp);
                }
            }

            while (count-- > 0){
                buffer.offerFirst(curMin);
            }
        }

        while (!buffer.isEmpty()){
            input.offerFirst(buffer.pollFirst());
        }
    }
}
