package Laicode.Algorithm.CrossTrainningII;

/*
*Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.

Assumptions

The given array is not null and has length of at least 3
No duplicate triples should be returned, order of the values in the tuple does not matter
Examples

A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]


* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right){
                int  tmp = array[left] + array[right];
                if (tmp + array[i] == target){
                    res.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while (left < right && array[left] == array[left - 1]){
                        left++;
                    }
                }else if (tmp + array[i] < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
