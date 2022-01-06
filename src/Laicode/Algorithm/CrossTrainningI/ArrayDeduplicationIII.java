package Laicode.Algorithm.CrossTrainningI;

/*
* Given a sorted integer array, remove duplicate elements.
* For each group of elements with the same value do not keep any of them. Do this in-place,
* using the left side of the original array and and maintain the relative order of the elements of the array.
*  Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1}
* */

import java.util.Arrays;

public class ArrayDeduplicationIII {
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1){
            return array;
        }
        int end = 0;
        boolean flag = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[end]){
                flag = true;
            }else if (flag == true){
                array[end] = array[i];
                flag = false;
            }else {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, flag ? end : end + 1);
    }


    //Time  Complexity: O(n)
    //Space Complexity: O(1)
}
