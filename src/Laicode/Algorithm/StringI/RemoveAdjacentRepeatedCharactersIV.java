package Laicode.Algorithm.StringI;

/*
* Repeatedly remove all adjacent, repeated characters in a given string from left to right.

No adjacent characters should be identified in the final string.

Examples

"abbbaaccz" → "aaaccz" → "ccz" → "z"
"aabccdc" → "bccdc" → "bdc"
* */

public class RemoveAdjacentRepeatedCharactersIV {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() == 1){
            return input;
        }
        char[] res = input.toCharArray();
        int end = 0;
        for (int i = 1; i < res.length; i++) {
            if (end == -1 || res[end] != res[i]){
                res[++end] = res[i];
            }else {
                end--;
                while (i + 1 < res.length && res[i] == res[i + 1]){
                    i++;
                }
            }
        }
        return new String(res, 0, end + 1);
    }
}
