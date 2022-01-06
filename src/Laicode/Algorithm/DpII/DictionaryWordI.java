package Laicode.Algorithm.DpII;

/*
* Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions

The given word is not null and is not empty
The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
Examples

Dictionary: {“bob”, “cat”, “rob”}

Word: “robob” return false

Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
* */

import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {
    public boolean canBreak(String input, String[] dict) {
        // Assumptions:
        // Input is not null or empty.
        // Dict is not null or empty
        // All the strings in dict is not null or empty
        Set<String> dictSet = toSet(dict);
        boolean[] canbreak = new boolean[input.length() + 1];
        canbreak[0] = true;
        for (int i = 1; i < canbreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dictSet.contains(input.substring(j, i)) && canbreak[j]){
                    canbreak[i] = true;
                    break;
                }
            }
        }
        return canbreak[canbreak.length - 1];
    }

    private Set<String> toSet(String[] dict){
        Set<String> set = new HashSet<>();
        for (String s: dict
             ) {
            set.add(s);
        }
        return set;
    }
    //Time  Complexity: O(n ^ 2);
    //Space Complexity: O(n);
}
