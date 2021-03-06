package Laicode.Algorithm.DpIII;

/*
* Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

Assumptions

The given array is not null
Examples

{0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
* */

public class LongestConsecutive1s {
    public int longest(int[] array){
        int count = 0;
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1){
                count++;
            }else {
                count = 0;
            }
            res = Math.max(res, count);
        }
        return res;
    }
    //Time  Complexity: O(n)
    //Space Complexity: O(n)
}
