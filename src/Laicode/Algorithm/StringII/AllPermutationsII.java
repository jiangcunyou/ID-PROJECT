package Laicode.Algorithm.StringII;

/*
* Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []
* */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if (input == null){
            return res;
        }
        char[] array = input.toCharArray();
        helper(array, 0, res);
        return res;
    }

    public void helper(char[] array, int index, List<String> res){
        if (index == array.length){
            //base case: when we have determined for all the indices of
            //the current permutation which element to choose
            res.add(new String(array));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])){
                swap(array, i, index);
                helper(array, index + 1, res);
                swap(array, i, index);
            }
        }
    }

    public void swap(char[] array, int left, int right){
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}

//TC: O(n * n!)
//SC: O(n * n!)