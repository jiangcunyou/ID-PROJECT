package Laicode.midExam;

import java.util.ArrayList;
import java.util.List;

/*
* Find all valid ways of putting N Queens on an N * N chessboard so that no two Queens can attack each other (two queens can attack each other if they are on the same row/column or same diagonal line).
You can define your own way of how to print the solution, e.g. using a size N array/List to record which column the queen occupies on each row.

* */
public class NQueens {
    //Validate the queen position in O(1) each time
    public List<List<Integer>> nqueens(int n){
        // Assumptions: n > 0.
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //cur will be a list of size n, and cur[i] is the column number
        //where the queen in row i positioned.
        int[] cur = new int[n];
        //record on which columns there is already a queen
        boolean[] usedColumns = new boolean[n];
        //record on which diagonal lines there is already a queen
        boolean[] usedDiagonals = new boolean[2 * n - 1];
        //record on which reverse diagonal lines there is already a queen.
        boolean[] usedRevDiagonals = new boolean[2 * n - 1];
        helper(n, 0, cur, res, usedColumns, usedDiagonals, usedRevDiagonals);
        return res;
    }

    private void helper(int n, int row, int[] cur, List<List<Integer>> res, boolean[] usedColumns,
                        boolean[] usedDiagonals, boolean[] usedRevDiagonals){
        //base case: when for all the rows we know where the queen is positioned.
        if (row == n){
            res.add(toList(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals)){
                mark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
                cur[row] = i;
                helper(n, row + 1, cur, res, usedColumns, usedDiagonals, usedRevDiagonals);
                unmark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
            }
        }
    }

    private boolean valid(int n, int row, int column, boolean[] usedColumns,
                          boolean[] usedDiagonals, boolean[] usedRevDiagonals){
        //for the reverse diagonal line, the actual range of column - row is
        //actually [-(n-1), +(n-1)]
        //we add n - 1 to make sure it can fit into the index.
        return !usedColumns[column] && !usedDiagonals[column + row]
                && !usedRevDiagonals[column - row + n -1];
    }

    private void mark(int n, int row, int column, boolean[] usedColumns,
                      boolean[] usedDiagonals, boolean[] usedRevDiagonals){
        usedColumns[column] = true;
        usedDiagonals[column + row] = true;
        usedRevDiagonals[column - row + n -1] = true;
    }

    private void unmark(int n, int row, int column, boolean[] usedColumns,
                      boolean[] usedDiagonals, boolean[] usedRevDiagonals){
        usedColumns[column] = false;
        usedDiagonals[column + row] = false;
        usedRevDiagonals[column - row + n -1] = false;
    }

    private List<Integer> toList(int[] array){
        List<Integer> list = new ArrayList<>();
        for (int num: array) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        nq.nqueens(8);
    }
}

//Time Complexity:  O(n!)
//Space Complexity: o(n)
