package Laicode.Algorithm.StringII;

/*
* Reverse a given string.

Assumptions

The given string is not null.
* */

public class ReverseString {
    public String reverse(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1){
            return input;
        }
        char[] res = input.toCharArray();
        for (int left = 0, right = res.length - 1; left < right; left++, right--) {
            swap(res, left, right);
        }
        return new String(res);
    }

    public void swap(char[] res, int left, int right){
        char tmp = res[left];
        res[left] = res[right];
        res[right] = tmp;
        left++;
        right--;
    }
}

//TC: O(n)
//SC: O(n)