package Laicode.Algorithm.RecursionIII;

//    Maximum Path Sum Binary Tree II
//    Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same).
//
//    Assumptions
//
//    ​The root of the given binary tree is not null
//    Examples
//
//    -1
//
//    /    \
//
//    2      11
//
//    /    \
//
//    6    -14
//
//    one example of paths could be -14 -> 11 -> -1 -> 2
//
//    another example could be the node 11 itself
//
//    The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

public class MaximumPathBTII {
    public int maxPathSum(TreeNode root) {
        // Assumptions: root is not null, max stores the global maximum path sum and will be updated during the recursion
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    public int helper(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max[0] = Math.max(root.key + left + right, max[0]);
        return root.key + Math.max(left, right);
    }
}

//TC: O(n)
//SC: O(h)
