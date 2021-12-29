package Laicode.Algorithm.DpI;

/*
* Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

Assumptions

The given array is not null
Examples

{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.

{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
* */

public class LongestAscendingSubArray {
    public int longest(int[] array) {
        // Write your solution here
        if (array.length == 0){
            return  0 ;
        }
        int globalmax = 1;
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]){
                globalmax = Math.max(globalmax, ++count);
            }else {
                count = 1;
            }
        }
        return globalmax;
    }
}
