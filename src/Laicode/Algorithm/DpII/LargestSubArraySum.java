package Laicode.Algorithm.DpII;

/*
* Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

Assumptions

The given array is not null and has length of at least 1.
Examples

{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

{-2, -1, -3}, the largest subarray sum is -1
* */

public class LargestSubArraySum {
//    public int largestSum(int[] array) {
//        // Write your solution here
//        int globalmax = array[0];
//        int[] m = new int[array.length];
//        m[0] = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if(m[i - 1] > 0){
//                m[i] = array[i] + m[i - 1];
//            }else {
//                m[i] = array[i];
//            }
//            globalmax = Math.max(m[i], globalmax);
//        }
//        return globalmax;
//    }

    public int largestSum(int[] array){
        int result = array[0];
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            result = Math.max(result, cur);
        }
        return result;
    }

    //Time  Complexity: O(n)
    //Space Complexity: O(1)
}
