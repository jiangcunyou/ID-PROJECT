package Laicode.practice.Sort;

import java.util.Random;

public class Quicksort {

    private Random random = new Random();

    public void swap(int[] array, int x, int y){

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public void quickSort(int[] array, int left, int right){

        if (left >= right)
            return;

        int pivotindex = left + random.nextInt(right - left + 1);

        swap(array, pivotindex, right);

        int i = left;
        int j = right - 1;

        while (i <= j){
            if (array[i] > array[right])
            {
                swap(array, i, j);
                j--;
            }else{
                i++;
            }
        }

        swap(array, i, right);

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

    public void quickSort(int[] array){

        if (array == null || array.length == 0)
            return;

        quickSort(array, 0, array.length - 1);

    }

    public static void main(String[] args) {
        int[] a = {3,1,2,5,9,0};

        Quicksort quicksort = new Quicksort();
        quicksort.quickSort(a);

        for (int i :
                a) {
            System.out.print(i + ", ");
        }
    }
}
