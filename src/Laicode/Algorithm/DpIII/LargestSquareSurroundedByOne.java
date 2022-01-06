package Laicode.Algorithm.DpIII;

/*
* Determine the largest square surrounded by 1s in a binary matrix
* (a binary matrix only contains 0 and 1), return the length of the largest square.



Assumptions

The given matrix is guaranteed to be of size M * N, where M, N >= 0



Examples

{{1, 0, 1, 1, 1},

 {1, 1, 1, 1, 1},

 {1, 1, 0, 1, 0},

 {1, 1, 1, 1, 1},

 {1, 1, 1, 0, 0}}



The largest square surrounded by 1s has length of 3.
* */

public class LargestSquareSurroundedByOne {
    public int largestSquareSurroundedByOne(int[][] matrix) {
        // Write your solution here
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1){
                    left[i + 1][j + 1] = left[i + 1][j] + 1;
                    up[i + 1][j + 1] = up[i][j + 1] + 1;
                    for (int maxlength = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); maxlength >= 0; maxlength--){
                        if (left[i + 2 - maxlength][j + 1] >= maxlength && up[i + 1][j + 2 - maxlength] >= maxlength){
                            res = Math.max(res, maxlength);
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,0,1,1,1}, {1,1,1,1,1}, {1,1,0,1,0},{1,1,1,1,1},{1,1,1,0,0}};

        LargestSquareSurroundedByOne lssb = new LargestSquareSurroundedByOne();
        lssb.largestSquareSurroundedByOne(matrix);
    }
}
