package Laicode.Algorithm.BFS;

/*
* Given a matrix of size N x M. For each row the elements are sorted in ascending order,
* and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

Assumptions

the matrix is not null, N > 0 and M > 0
K > 0 and K <= N * M
Examples

{ {1,  3,   5,  7},

  {2,  4,   8,   9},

  {3,  5, 11, 15},

  {6,  8, 13, 18} }

the 5th smallest number is 4
the 8th smallest number is 6
* */

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
    static class Cell{
        int row;
        int column;
        int value;

        Cell(int row, int column, int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        int rows = matrix.length;
        int columns = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value == o2.value){
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[rows][columns];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]){
                minHeap.offer(new Cell(cur.row + 1,
                        cur.column, matrix[cur.row + 1][columns]));
                visited[cur.row + 1][columns] = true;
            }
            if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]){
                minHeap.offer(new Cell(cur.row, cur.column + 1,
                        matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }
        return minHeap.peek().value;
    }
}
