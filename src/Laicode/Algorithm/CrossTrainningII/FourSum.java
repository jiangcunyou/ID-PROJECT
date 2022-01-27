package Laicode.Algorithm.CrossTrainningII;

/*
* Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions

The given array is not null and has length of at least 4
Examples

A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

A = {1, 2, 2, 3, 4}, target = 12, return false


* */

import java.util.Arrays;

public class FourSum {
    //Assumptions: array is not null, and array.length >= 4
    public boolean exist(int[] array, int target) {
        // Write your solution here
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            for (int j = i + 1; j < array.length - 2; j++) {
                int left = j + 1;
                int right = array.length - 1;
                int cur = target - array[i] - array[j];
                while (left < right){
                    int sum = array[left] + array[right];
                    if (sum == cur){
                        return true;
                    }else if (sum < cur){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return false;
    }

    //TC: O(n ^ 3)
}
