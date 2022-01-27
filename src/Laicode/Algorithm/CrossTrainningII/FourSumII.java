package Laicode.Algorithm.CrossTrainningII;

import java.util.HashMap;
import java.util.Map;

class Pair{
    int left;
    int right;

    Pair(int left, int right){
        this.left = left;
        this.right = right;
    }
}

public class FourSumII {
    public boolean exist(int[] array, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int pairSum = array[j] + array[i];
                if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j){
                    return true;
                }
                if (!map.containsKey(pairSum)){
                    map.put(pairSum, new Pair(j, i));
                }
            }
        }
        return false;
    }
}

//TC: O(n ^ 2)