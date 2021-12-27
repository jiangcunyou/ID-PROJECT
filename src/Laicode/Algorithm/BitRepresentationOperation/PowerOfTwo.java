package Laicode.Algorithm.BitRepresentationOperation;

/*
* Determine if a given integer is power of 2.

Examples

16 is power of 2 (2 ^ 4)
3 is not
0 is not
-1 is not
* */

// 0001 0000
// 0000 0001
public class PowerOfTwo {
    public boolean isPowerofTwo(int number){
        if (number < 0){
            return false;
        }
        while ((number & 1) == 0){
            number >>>= 1;
        }

        return number == 1;
    }
}

//Time  Complexity: O(log2n)
//Space Complexity: O(1)