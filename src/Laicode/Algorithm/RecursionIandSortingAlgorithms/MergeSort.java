package Laicode.Algorithm.RecursionIandSortingAlgorithms;

/*
* Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
* */

public class MergeSort {
    //Normal way.
//    public int[] merge(int[] array){
//        if (array == null || array.length == 0){
//            return array;
//        }
//        return  merge(array, 0, array.length - 1);
//    }
//
//    public int[] merge(int[] array, int left, int right){
//        if (left == right){
//            return new int[]{array[left]};
//        }
//        int mid = left + (right - left) / 2;
//        int[] leftresult = merge(array, left, mid);
//        int[] rightresult = merge(array, mid + 1, right);
//        return merge(leftresult, rightresult);
//    }
//
//    public int[] merge(int[] one, int[] two){
//        int[] result = new int[one.length + two.length];
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        while (i < one.length && j < two.length){
//            if (one[i] < two[j]){
//                result[k++] = one[i++];
//            }else {
//                result[k++] = two[j++];
//            }
//        }
//        while (i < one.length){
//            result[k++] = one[i++];
//        }
//        while (j < two.length){
//            result[k++] = two[j++];
//        }
//        return result;
//    }

    //Better way
    public int[] mergeSort(int[] array){
        //Check null array first
        if (array == null){
            return array;
        }
        // Allocate helper array to help merge step
        // so that we guarantee no more than O(n) space is used
        // The space complexity is O(n) in this case.
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right){
        if (left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right){
        // copy the content to helper array and we will merge from
        // the helper array
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right){
            if (helper[leftIndex] <= helper[rightIndex]){
                array[left++] = helper[leftIndex++];
            }else {
                array[left++] = helper[rightIndex++];
            }
        }
        //if we still have some elements at left side, we need to copy them
        while (leftIndex <= mid){
            array[left++] = helper[leftIndex++];
        }
        //if there are some elements at rightside, we do not need to copy them
        //because they are already in their position.
    }

    //Time complexity:  O(nlogn)
    //Space complexity: O(n)
}
