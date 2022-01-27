package Laicode.Algorithm.RecursionIII;

/*
* Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

Examples

  -15

  /    \

2      11

     /    \

    6     14

The maximum path sum is 6 + 11 + 14 = 31.

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

public class MaximumPathBTI {
    public int maxPathSum(TreeNode root) {
        // Write your solution here
        if(root == null){
            return 0;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        if(root.left != null && root.right != null){
            max[0] = Math.max(max[0], left + right + root.key);
            return Math.max(left, right) + root.key;
        }
        return root.left == null ? right + root.key : left + root.key;
    }

}
