package Laicode.Algorithm.DpIII;

/*
* Determine the largest square surrounded by a bunch of matches (each match is either horizontal or vertical), return the length of the largest square.

The input is a matrix of points. Each point has one of the following values:

0 - there is no match to its right or bottom.

1 - there is a match to its right.

2 - there is a match to its bottom.

3 - there is a match to its right, and a match to its bottom.



Assumptions

The given matrix is guaranteed to be of size M * N, where M, N >= 0



Examples

{{3, 1, 1, 3, 0, 1, 1, 0},

 {2, 0, 0, 2, 0, 0, 0, 0},

 {3, 1, 3, 0, 0, 0, 0, 0},

 {2, 0, 2, 0, 0, 0, 0, 0},

 {1, 1, 0, 0, 0, 0, 0, 0}}



This matrix represents the following bunch of matches:



The largest square has length of 2.


* */

public class LargestSquareOfMatches {
    public int largestSquareOfMatches(int[][] matrix) {
        // Write your solution here
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        int[][] right=  new int[n + 1][m + 1];
        int[][] down =  new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (hasright(matrix[i][j])){
                    right[i][j] = right[i][j + 1] + 1;
                }
                if (hasdown(matrix[i][j])){
                    down[i][j] = down[i + 1][j] + 1;
                }
                if (hasboth(matrix[i][j])){
                    for (int maxlength = Math.min(right[i][j], down[i][j]); maxlength >= 1; maxlength--) {
                        if (right[i + maxlength][j] >= maxlength && down[i][j + maxlength] >= maxlength){
                            res = Math.max(res, maxlength);
                            break;
                        }
                    }
                }
            }
        }
        return res;

    }
    private boolean hasright(int value){
        return (value & 0b1) != 0;
    }
    private boolean hasdown(int value){
        return (value & 0b10) != 0;
    }
    private boolean hasboth(int value){
        return value == 0b11;
    }

    //Time  Complexity: O(n * m * min(n, m))
    //Space Complexity: O(n * m)
}
