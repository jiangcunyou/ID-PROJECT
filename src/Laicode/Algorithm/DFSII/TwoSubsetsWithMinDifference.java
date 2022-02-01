package Laicode.Algorithm.DFSII;


/*
* Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.

Return the minimum difference(absolute value).

Assumptions:

The given integer array is not null and it has length of >= 2.
Examples:

{1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwoSubsetsWithMinDifference {
    public int minDifference(int[] array) {

        int sum = sum(array);
        Integer[] total = new Integer[]{sum};
        Integer[] min = new Integer[]{Integer.MAX_VALUE};
        Integer[] cur = new Integer[]{0};
        List<Integer> list = new ArrayList<>();
        dfs(array, 0, total, min, cur, list);

        return min[0];
    }

    private int sum(int[] array){
        int sum = 0;
        for (int i :
                array) {
            sum += i;
        }
        return sum;
    }

    // not required the same size of two subsets;
    private void dfs(int[] array, int level, Integer[] total, Integer[] min, Integer[] cur, List<Integer> list){
        if (level == array.length){
            if (Math.abs(total[0] - cur[0] - cur[0]) < min[0]){
                min[0] = Math.abs(total[0] - cur[0] - cur[0]);
            }
            return;
        }
        list.add(array[level]);
        dfs(array, level + 1, total, min, new Integer[]{cur[0] + array[level]}, list);
        list.remove(list.size() - 1);
        dfs(array, level + 1, total, min, cur, list);
    }

    //if required the size of two subsets are equal.
    private void dfsequal(int[] array, int level, Integer[] total, Integer[] min, Integer[] cur, List<Integer> list){
        if (level == array.length){
            if ((array.length % 2 == 0 && list.size() == array.length / 2) || (array.length % 2 == 1 && (list.size() == array.length / 2 || list.size() == array.length / 2 + 1))){
                if (Math.abs(total[0] - cur[0] - cur[0]) < min[0]){
                    min[0] = Math.abs(total[0] - cur[0] - cur[0]);
                }

            }
            return;
        }
        list.add(array[level]);
        dfsequal(array, level + 1, total, min, new Integer[]{cur[0] + array[level]}, list);
        list.remove(list.size() - 1);
        dfsequal(array, level + 1, total, min, cur, list);
    }
}
