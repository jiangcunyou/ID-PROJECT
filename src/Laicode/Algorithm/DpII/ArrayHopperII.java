package Laicode.Algorithm.DpII;

/*
* Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
* A[i] means the maximum jump distance from index i (you can only jump towards the end of the array).
* Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

Assumptions

The given array is not null and has length of at least 1.
Examples

{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
* */

public class ArrayHopperII {
    public int minJump(int[] array) {
        // Write your solution here
        int[] minJump = new int[array.length];
        minJump[0] = 0;
        for (int i = 1; i < array.length; i++) {
            minJump[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && minJump[j] != -1){
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1){
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[array.length - 1];
    }
}
