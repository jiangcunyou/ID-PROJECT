package Laicode.Algorithm.DFSII;

/*
* Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K. Notice that each subset returned will be sorted for deduplication.



Assumptions

There could be duplicate characters in the original set.

​

Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "abb", K = 2, all the subsets are [“ab”, “bb”].

Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].

Set = null, K = 0, all the subsets are [].
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsIIofSizeK {
    public List<String> subSetsIIOfSizeK(String set, int k) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if (set == null){
            return res;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        helper(array, k, sb, 0, res);
        return res;
    }

    private void helper(char[] array, int k, StringBuilder sb, int index, List<String> res){
        if (sb.length() == k){
            res.add(sb.toString());
            return;
        }
        if (index == array.length){
            return;
        }
        helper(array, k, sb.append(array[index]), index + 1, res);
        sb.deleteCharAt(sb.length() - 1);
        while (index < array.length - 1 && array[index] == array[index + 1]){
            index++;
        }
        helper(array, k, sb, index + 1, res);
    }
}
