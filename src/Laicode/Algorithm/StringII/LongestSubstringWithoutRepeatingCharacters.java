package Laicode.Algorithm.StringII;

/*
* Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.

For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
* */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        // Write your solution here
        Set<Character> dis = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < input.length()){
            if (dis.contains(input.charAt(fast))){
                dis.remove(input.charAt(slow++));
            }else {
                dis.add(input.charAt(fast++));
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }
}

//Time Complexity:   O(n + d) n is the length of the String and, d is the number of characters
// in input string alphabet
//Space Complexity:  O(d)