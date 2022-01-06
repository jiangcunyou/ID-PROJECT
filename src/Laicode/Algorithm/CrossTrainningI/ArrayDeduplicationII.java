package Laicode.Algorithm.CrossTrainningI;

/*
*Given a sorted integer array, remove duplicate elements.
* For each group of elements with the same value keep at most two of them. Do this in-place,
* using the left side of the original array and maintain the relative order of the elements of the array.
* Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
* */

import java.util.Arrays;

public class ArrayDeduplicationII {
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length <= 2){
            return array;
        }
        int end = 1;
        for (int i = 2; i < array.length; i++) {
            if (array[i] != array[end - 1]){
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }
    //Time  Complexity: O(n)
    //Space Complexity: O(1)
}
