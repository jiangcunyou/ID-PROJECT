package Laicode.Algorithm.StringI;

/*
* Remove given characters in input string, the relative order of other characters
* should be remained. Return the new string after deletion.

Assumptions

The given input string is not null.
The characters to be removed is given by another string, it is guaranteed to be not null.
Examples

input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
* */

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        // Write your solution here
        char[] array = input.toCharArray();
        Set<Character> set = buildSet(t);
        
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (!set.contains(array[fast])){
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }

    public Set<Character> buildSet(String t){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        return set;
    }
}

//Time complexity: O(m + n)
//Space complexity: O(m + n)