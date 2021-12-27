package Laicode.practice.Sort;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MergeSortArrayList {

    public ArrayList<Integer> mergeSort(ArrayList<Integer> array){

        if (array == null){

            return array;
        }

        return mergeSort(array, 0, array.size() - 1);
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> array, int left, int right){

        ArrayList<Integer> result = new ArrayList<>();
        if (left == right){

            result.add(array.get(left));
            return result;
        }

        int mid = left + (right - left) / 2;

        ArrayList<Integer> releft = mergeSort(array, left, mid);
        ArrayList<Integer> reright = mergeSort(array, mid + 1, right);

        merge(releft, reright, result);
        return  result;
    }

    public void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> result){

        int l = 0;
        int r = 0;

        while (l < left.size() && r < right.size()){

            if (left.get(l) < right.get(r)){
                result.add(left.get(l++));
            }else{
                result.add(right.get(r++));
            }
        }

        while (l < left.size()){
            result.add(left.get(l++));
        }

        while (r < right.size()){
            result.add(right.get(r++));
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> newFun = new ArrayList<>();

        newFun.add(7);
        newFun.add(3);
        newFun.add(2);


        MergeSortArrayList mergeSortArrayList = new MergeSortArrayList();
        ArrayList<Integer> result = mergeSortArrayList.mergeSort(newFun);

        for (int i = 0; i < newFun.size(); i++) {

            System.out.println(result.get(i));
        }
    }
}
