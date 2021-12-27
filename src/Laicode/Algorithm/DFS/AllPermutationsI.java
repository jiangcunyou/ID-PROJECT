package Laicode.Algorithm.DFS;

/*
* Given a string with no duplicate characters, return a list with all permutations of the characters.

Assume that input string is not null.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

Set = "", all permutations are [""]
* */

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsI {
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (input == null){
            return result;
        }
        char[] array = input.toCharArray();
        helper(array, 0, result);
        return result;
    }

    public void helper(char[] array, int index, List<String> result){
        if (index == array.length){
            result.add(new String(array));
            return;
        }
        for (int i = index; i < array.length; i++) {
            swap(array,index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
        }
    }

    public void swap(char[] array, int index, int i){
        char tmp = array[index];
        array[index] = array[i];
        array[i] = tmp;
    }
}


