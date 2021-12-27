package Laicode.Algorithm.StringI;

/*
* Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.

Assumptions

Try to do it in place.
Examples

“aaaabbbc” is transferred to “abc”
Corner Cases

If the given string is null, returning null or an empty string are both valid.
* */

public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        // Write your solution here
        if (input.isEmpty()){
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (fast == 0 || array[fast] != array[slow - 1]){
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }
}

//Time: O(n)
//Space: O(n)