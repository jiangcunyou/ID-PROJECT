package Leetcode;

/*
* Given a string s, find the length of the longest substring without repeating characters.
* */

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingLetters {
    public int Longestsubstring(String s){
        int n = s.length();
        int globalmax = 0;
        Map<Character,Integer> map = new HashMap<>();
        int slow = 0;
        for(int i = 0; i < n; i++){
            if (map.containsKey(s.charAt(i))){
                slow = Math.max(slow, map.get(s.charAt(i)));
            }
            globalmax = Math.max(globalmax, i - slow + 1);
            map.put(s.charAt(i), i + 1);
        }
        return globalmax;
    }
}
