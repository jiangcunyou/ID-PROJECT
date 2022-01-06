package Laicode.Algorithm.DpIII;

/*
* Given a matrix that contains integers, find the submatrix with the largest sum.

Return the sum of the submatrix.

Assumptions

The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
Examples

{ {1, -2, -1, 4},

  {1, -1,  1, 1},

  {0, -1, -1, 1},

  {0,  0,  1, 1} }

the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
* */

public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        // Assumptions: matrix is not null, has size N * M and N, M >= 1.
        int N = matrix.length;
        int M = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[] cur = new int[M];
            for (int j = i; j < N; j++) {
                add(cur, matrix[j]);
                res = Math.max(res, max(cur));
            }
        }
        return res;
    }
    private void add(int[] cur, int[] add){
        for (int i = 0; i < cur.length; i++) {
            cur[i] += add[i];
        }
    }
    private int max(int[] cur){
        int tmp = cur[0];
        int res = cur[0];
        for (int i = 1; i <cur.length; i++) {
            tmp = Math.max(cur[i], tmp + cur[i]);
            res = Math.max(tmp, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ma = new int[][]{{1,-2,1,4},{1,-1,1,1},{0,-1,-1,1},{0,0,1,1}};
        LargestSubMatrixSum lsms = new LargestSubMatrixSum();
        lsms.largest(ma);
    }
}
