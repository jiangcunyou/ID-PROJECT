package Laicode.Algorithm.DpIII;

/*
*Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s,
* with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest X shape.

Assumptions

The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest X of 1s has arm length 2.
* */

public class LargestXOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        if (n == 0){
            return 0;
        }
        int m = matrix.length;
        if (m == 0){
            return 0;
        }
        int[][] leftup = leftup(matrix, n, m);
        int[][] rightdown = rightdown(matrix, n, m);
        return merge(leftup, rightdown, n ,m);
    }

    private int merge(int[][] leftup, int[][] rightdown, int n, int m){
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                leftup[i][j] = Math.min(leftup[i][j], rightdown[i][j]);
                res = Math.max(res, leftup[i][j]);
            }
        }
        return res;
    }

    private int[][] leftup(int[][] matrix, int n, int m){
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1){
                    left[i][j] = getnumber(left, i - 1, j - 1, n ,m) + 1;
                    up[i][j] = getnumber(up, i - 1, j + 1, n, m) + 1;
                }
            }
        }
        merge(left, up ,n ,m);
        return left;
    }

    private int[][] rightdown(int[][] matrix, int n, int m){
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1)
                right[i][j] = getnumber(right, i + 1, j + 1, n, m) + 1;
                down[i][j] = getnumber(down, i + 1, j - 1, n, m) + 1;
            }
        }
        merge(right, down, n, m);
        return right;
    }
    private int getnumber(int[][] left, int x, int y, int n, int m){
        if (x < 0 || y < 0 || x >= n || y >= m){
            return 0;
        }
        return left[x][y];
    }
}
