package Laicode.Algorithm.StringI;

/*
* Given a string, remove all leading/trailing/duplicated empty spaces.

Assumptions:

The given string is not null.
Examples:

“  a” --> “a”
“   I     love MTV ” --> “I love MTV”
* */

public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        if (input.isEmpty()){
            return input;
        }
        char[] res = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < res.length; fast++) {
            if (res[fast] == ' ' && (fast == 0 || res[fast - 1] == ' ')){
                continue;
            }
            res[slow++] = res[fast];
        }

        if (slow > 0 && res[slow - 1] == ' '){
            slow--;
        }

        return new String(res, 0, slow);
    }
}

// Time Complexity:   O(n)
// Space Complexity:  O(n)
