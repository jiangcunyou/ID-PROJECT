package Laicode.Algorithm.CrossTrainningI;

/*
* Use the least number of comparisons to get the largest and 2nd largest number in the given integer array.
* Return the largest number and 2nd largest number.

Assumptions

The given array is not null and has length of at least 2
Examples

{2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
* */

import java.util.ArrayList;
import java.util.List;

public class LargestAndSecondLargest {
    static class Element{
        int value;
        List<Integer> compredValues;

        Element(int value){
            this.value = value;
            this.compredValues = new ArrayList<>();
        }
    }
    public int[] largestAndSecond(int[] array) {
        Element[] helper = convert(array);
        int largerlength = array.length;
        while (largerlength > 1){
            compareAndSwap(helper, largerlength);
            largerlength = (largerlength + 1) / 2;
        }
        return new int[]{helper[0].value, largest(helper[0].compredValues)};
    }

    private Element[] convert(int[] array){
        Element[] helper = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            helper[i] = new Element(array[i]);
        }
        return helper;
    }

    private void compareAndSwap(Element[] helper, int largerLength){
        for (int i = 0; i < largerLength / 2; i++) {
            if (helper[i].value < helper[largerLength - 1 - i].value){
                swap(helper, i, largerLength - 1 - i);
            }
            helper[i].compredValues.add(helper[largerLength - 1 - i].value);
        }
    }

    private void swap(Element[] helper, int left, int right){
        Element tmp = helper[left];
        helper[left] = helper[right];
        helper[right] = tmp;
    }

    private int largest(List<Integer> list){
        int max = list.get(0);
        for (int num :
                list) {
            max = Math.max(max, num);
        }
        return max;
    }
}
