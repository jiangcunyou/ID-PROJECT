package Laicode.Algorithm.DpII;

/*
* Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1),
* return the length of the largest square.

Assumptions

The given matrix is not null and guaranteed to be of size N * N, N >= 0
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1}}

the largest square of 1s has length of 2


* */

public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        if (n == 0){
            return 0;
        }
        int res = 0;
        int[][] largest = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0){
                    largest[i][j] = matrix[i][j] == 1 ? 1 : 0;
                }else if (matrix[i][j] == 1){
                    largest[i][j] = Math.min(largest[i - 1][j] + 1, largest[i][j - 1] + 1);
                    largest[i][j] = Math.min(largest[i - 1][j - 1] + 1, largest[i][j]);
                }
                res = Math.max(res, largest[i][j]);
            }
        }
        return res;
    }
    //Time Complexity : O(n * n)
    //Space Complexity: O(n * n)
}
