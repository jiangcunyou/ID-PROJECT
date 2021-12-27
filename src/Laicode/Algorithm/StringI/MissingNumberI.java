package Laicode.Algorithm.StringI;

/*
* Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.

Assumptions

The given array is not null, and N >= 1
Examples

A = {2, 1, 4}, the missing number is 3
A = {1, 2, 3}, the missing number is 4
A = {}, the missing number is 1
* */

public class MissingNumberI {
    public int missing(int[] array) {
        // Write your solution here
        int n = array.length + 1;
        long total = (n + 0L) * (n + 1) / 2;
        long actual = 0;
        for(int x: array){
            actual += x;
        }
        return (int)(total - actual);
    }
}
