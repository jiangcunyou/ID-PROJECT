package Laicode.practice.Sort;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {2,1,1,3,35,24,3,2,1,3,7,6,58};
        int n = array.length;

        selection(array, n);
        for (int i = 0; i < n; i++) {

            System.out.println(array[i]);
        }
    }

    public static void selection(int[] array, int n){

        for (int i = 0; i < n; i++) {
            int globalMin = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[globalMin])
                    globalMin = j;
            }

            int temp = array[i];
            array[i] = array[globalMin];
            array[globalMin] = temp;
        }

    }

}
