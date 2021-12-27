package Laicode.Algorithm.RecursionII;

/*
* Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

Assumptions

N > 0
Return

A list of ways of putting the N Queens
Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
Example

N = 4, there are two ways of putting 4 queens:

[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3,
* the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0,
* the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.

* */

import java.util.ArrayList;
import java.util.List;

public class Nqueens {
    //Method1: validate the queen position in O(n) each time
//    public List<List<Integer>> nqueens(int n) {
//        // Assumptions: n > 0
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        List<Integer> cur = new ArrayList<>();
//        helper(n, cur, res);
//        return res;
//    }
//
//    private void helper(int n, List<Integer> cur, List<List<Integer>> res){
//        if (cur.size() == n){
//            res.add(new ArrayList<>(cur));
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if (valid(cur, i)){
//                cur.add(i);
//                helper(n, cur, res);
//                cur.remove(cur.size() - 1);
//            }
//        }
//    }
//
//    private boolean valid(List<Integer> cur, int column){
//        int row = cur.size();
//        for (int i = 0; i < row; i++) {
//            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i){
//                return false;
//            }
//        }
//        return true;
//    }
    //TIME COMPLEXITY: O(n! * n)
    //SPACE COMPLEXITY: O(n)


    //Method 2: validate the queen position in O(1) time
    public List<List<Integer>> nqueensII(int n){
        List<List<Integer>> res = new ArrayList<>();
        //cur will be the list of size n, and cur[i] is the column number
        //where the queen in row i positioned
        int[] cur = new int[n];
        boolean[] usedColumns = new boolean[n];
        boolean[] usedDiagonals = new boolean[2 * n - 1];
        boolean[] usedRevDiagonals = new boolean[2 * n - 1];
        helper(n, 0, cur, res, usedColumns, usedDiagonals, usedRevDiagonals);
        return res;
    }

    public void helper(int n, int row, int[] cur, List<List<Integer>> res, boolean[] usedColumns,
                       boolean[] usedDiagonals, boolean[] usedRevDiagonals){
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

    private boolean valid(int n, int row, int columns, boolean[] usedColumns,
                       boolean[] usedDiagonals, boolean[] usedRevDiagonals){
        return !usedColumns[columns] && !usedDiagonals[columns + row] && !usedRevDiagonals[columns - row + n - 1];
    }

    private void mark(int n, int row, int columns, boolean[] usedColumns,
                      boolean[] usedDiagonals, boolean[] usedRevDiagonals){
        usedColumns[columns] = true;
        usedDiagonals[columns + row] = true;
        usedRevDiagonals[columns - row + n - 1] = true;
    }

    private void unmark(int n, int row, int columns, boolean[] usedColumns,
                      boolean[] usedDiagonals, boolean[] usedRevDiagonals){
        usedColumns[columns] = false;
        usedDiagonals[columns + row] = false;
        usedRevDiagonals[columns - row + n - 1] = false;
    }

    private List<Integer> toList(int[] array){
        List<Integer> list = new ArrayList<>();
        for(int num : array){
            list.add(num);
        }
        return list;
    }

    //Time complexity:      O(n!);
    //Space complexity:     O(n);

    public static void main(String[] args) {
        Nqueens nq = new Nqueens();
        int n = 5;
        nq.nqueensII(5);
    }
}
