package Laicode.Algorithm.CrossTrainningI;

/*
* In a binary search tree, find k nodes containing the closest numbers to the given target number. return them in sorted array

Assumptions:

The given root is not null.
There are no duplicate keys in the binary search tree.
Examples:

    5

  /    \

2      11

     /    \

    6     14

closest number to 4 is 5

closest number to 10 is 11

closest number to 6 is 6

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
* */

import java.util.ArrayDeque;
import java.util.Deque;

public class ClosestNumberInBinarySearchTreeII {
    public int[] closestKValues(TreeNode root, double target, int k) {
        // Write your solution here
        Deque<TreeNode> deque = new ArrayDeque<>();
        helper(root, target, k, deque);
        int size = deque.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            TreeNode re= deque.pollFirst();
            res[i] = re.key;
        }
        return res;
    }

    private void helper(TreeNode root, double target, int k, Deque<TreeNode> deque){
        if (root == null){
            return;
        }
        helper(root.left, target, k, deque);
        if (deque.size() < k){
            deque.offerLast(root);
        }else {
            TreeNode tmp = deque.peekFirst();
            if (Math.abs(root.key - target) < Math.abs(tmp.key - target)){
                deque.pollFirst();
                deque.offerLast(root);
            }else {
                return;
            }
        }
        helper(root.right, target, k, deque);
    }
}
