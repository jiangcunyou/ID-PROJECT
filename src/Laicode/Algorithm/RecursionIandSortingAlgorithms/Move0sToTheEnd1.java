package Laicode.Algorithm.RecursionIandSortingAlgorithms;

/*
* Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array does not need to be maintained.

Assumptions:

The given array is not null.
Examples:

{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
* */

public class Move0sToTheEnd1 {
    public int[] moveZero(int[] array) {
        if(array == null || array.length <= 1){
            return array;
        }
        int left = 0;
        int right = array.length - 1;

        while(left <= right){
            if(array[left] != 0){
                left++;
            }else if(array[right] == 0){
                right--;
            }else{
                swap(array, left++, right--);
            }
        }
        return array;
    }

    public void swap(int[] array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}

//Time complexity:  O(n)
//Space complexityL O(1)
