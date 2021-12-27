package Laicode.practice.Sort;

public class RainbowSort {

    public int[] rainbowSort(int[] array){

        if (array == null || array.length <=  1){
            return array;
        }

        int neg = 0;
        int zero = 0;
        int one = array.length - 1;

        while(zero <= one){
            if(array[zero] == -1){
                swap(array, neg++, zero++);
            }else if(array[zero] == 0)
                zero++;
            else{
                swap(array, zero, one--);
            }
        }

        return array;
    }

    public void swap(int[] array, int a, int b){

        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;

    }
}
