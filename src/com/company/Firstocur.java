package com.company;

public class Firstocur {
    public static void main(String[] args) {

        int arr[] = {1,2,3,3,3,4,5,6,7};
        int x = firstoccur(arr,3);

        System.out.println(x);
    }

    public static int firstoccur(int array[], int target){
        if (array == null || array.length ==0){
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1){

            int mid = left + (right - left) / 2;
            if (array[mid] >= target){
                right = mid;
            }else {
                left = mid;
            }
        }

        if (array[left] == target){
            return left;
        }else if (array[right] == target){
            return right;
        }

        return -1;
    }
}
