package Laicode.Algorithm.DFSII;

/*
* Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.



Examples

Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”, “ba”, “bac”, “bc”, “bca”, “c”, “cb”, “cba”, “ca”, “cab”].

Set = “”, all permutations are [“”].

Set = null, all permutations are [].
* */

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsofSubsets {
    public List<String> allPermutationsOfSubsets(String set) {
        List<String> res = new ArrayList<>();
        // Write your solution here
        if (set == null){
            return res;
        }

        char[] array = set.toCharArray();
        helper(array, 0, res);
        return res;
    }

    private void helper(char[] array, int index, List<String> res){
        res.add(new String(array, 0, index));

        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            helper(array, index + 1, res);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right){
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        AllPermutationsofSubsets aps = new AllPermutationsofSubsets();
        aps.allPermutationsOfSubsets("abc");
    }
}
