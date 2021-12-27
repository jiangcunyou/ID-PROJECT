package Laicode.Algorithm.DFS;

/*
* Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions

There are no duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
* */

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        if (set == null){
            return result;
        }
        char[] arrayset = set.toCharArray();
        //record the current subset
        StringBuilder sb = new StringBuilder();
        helper(arrayset, sb, 0, result);
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result){
        //Terminate condition
        //when we finishes determing for all the characters pick or not,
        //we have a complete subset
        if (index == set.length){
            result.add(sb.toString());
            return;
        }
        //1. not pick the character at index
        helper(set, sb, index + 1, result);
        //2. pick the character at index
        helper(set, sb.append(set[index]), index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}

//Time complexity:  O(2 ^ n * n) where n is the length of given set
//Space complexity: O(n)