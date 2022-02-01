package Laicode.Algorithm.DFSII;

/*
* Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers, the output strings should be sorted.

{0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}

Assumptions:

The given number >= 0
Examples:

if input number is 231, possible words which can be formed are:

[ad, ae, af, bd, be, bf, cd, ce, cf]
* */

import java.util.ArrayList;
import java.util.List;

public class CombinationsForTelephonePadI {
    public String[] combinations(int number) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        String[] numtochar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(Integer.toString(number).toCharArray(), numtochar, 0, sb, res);
        return res.toArray(new String[0]);
    }

    private void helper(char[] number, String[] numtochar, int level, StringBuilder sb, List<String> res){
        if (level == number.length){
            res.add(sb.toString());
            return;
        }
        char[] chars = numtochar[number[level] - '0'].toCharArray();
        if (chars.length == 0){
            helper(number, numtochar, level + 1, sb, res);
        }else {
            for (int i = 0; i < chars.length; i++) {
                helper(number, numtochar, level + 1, sb.append(chars[i]), res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
