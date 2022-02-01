package Laicode.Algorithm.DFSII;

/*
* Given an integer number, return all possible combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3

              = 2 x 2 x 6

              = 2 x 3 x 4

              = 2 x 12

              = 3 x 8

              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.
* */

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        if (target <= 1){
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getfactor(target);
        helper(target, factors, 0, cur, res);
        return res;
    }

    private List<Integer> getfactor(int target){
        List<Integer> factors = new ArrayList<>();
        for (int i = target / 2; i > 1; i--) {
            if (target % i == 0){
                factors.add(i);
            }
        }
        return factors;
    }

    private void helper(int target, List<Integer> factors, int index, List<Integer> cur, List<List<Integer>> res){
        if (index == factors.size()){
            if (target == 1){
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        helper(target, factors, index + 1, cur, res);
        int factor = factors.get(index);
        int size = cur.size();
        while (target % factor == 0){
            cur.add(factor);
            target /= factor;
            helper(target, factors, index + 1, cur, res);
        }
        cur.subList(size, cur.size()).clear();
    }

    public static void main(String[] args) {
        FactorCombinations fcb = new FactorCombinations();
        fcb.combinations(12);
    }
}
