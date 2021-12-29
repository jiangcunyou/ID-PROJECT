package Laicode.Algorithm.DpI;

/*
* Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length
* p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined
* by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

Assumptions

n >= 2
Examples

n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
* */

public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        // Write your solution here
        if (length <= 0){
            return 0;
        }
        int[] array = new int[length + 1];
        array[1] = 0;
        for (int i = 2; i <= array.length; i++) {
            for (int j = 1; j < i; j++) {
                array[i] = Math.max(array[i], Math.max(j, array[j]) * (i - j));
            }
        }
        return array[length];
    }
    //Time  complexity: O(n ^ 2)
    //Space complexity: O(n)
}
