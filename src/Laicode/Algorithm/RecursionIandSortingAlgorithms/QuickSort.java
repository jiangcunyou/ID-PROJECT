package Laicode.Algorithm.RecursionIandSortingAlgorithms;

/*
* Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.

* */

import java.util.Random;

public class QuickSort {

    public Random random = new Random();

    public void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public int[] quickSort(int[] array){
        if (array == null || array.length == 0){
            return array;
        }
        return quickSort(array, 0, array.length - 1);
    }

    public int[] quickSort(int[] array, int left, int right){
        if (left >= right){
            return array;
        }
        int i = left;
        int j = right - 1;
        int pivot = left + random.nextInt(right - left + 1);
        swap(array, pivot, right);
        while (i <= j){
            if (array[i] > array[right]){
                swap(array, i, j--);
            }else {
                i++;
            }
        }
        swap(array, i, right);
        quickSort(array, left, i - 1);
        quickSort(array, i +1, right);
        return array;
    }
}

//Time complexity: worst case: O(n ^ 2), best case: O(nlogn)
//Space complexity: worst case: O(n), best case: O(logn)
