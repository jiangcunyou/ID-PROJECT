package Laicode.practice.Sort;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = {2,3,1,5,6,87,34,11};

        int[] result = mergesort(array, 0 , array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] mergesort(int[] array, int left, int right){

        if (left == right){
            return new int[]{array[left]};
        }

        int mid = left + (right - left) / 2;

        int[] leftresult = mergesort(array, left, mid);
        int[] rightresult = mergesort(array, mid + 1, right);

        int[] result = merge(leftresult, rightresult);

        return result;
    }

    public static int[] merge(int[] left, int[] right){

        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                result[k] = left[i];
                i++;
            }else {
                result[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < left.length){
            result[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length){
            result[k] = right[j];
            k++;
            j++;
        }

        return result;
    }
}
