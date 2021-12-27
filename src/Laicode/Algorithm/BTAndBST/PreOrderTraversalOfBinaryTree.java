package Laicode.Algorithm.BTAndBST;

/*
* Implement a recursive, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Pre-order traversal is [5, 3, 1, 4, 8, 11]

Corner Cases

What if the given binary tree is null? Return an empty list in this case.
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

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalOfBinaryTree {
    public List<Integer> preOrder(TreeNode root){

        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.key);
        helper(root.left, res);
        helper(root.right,res);
    }
}

// TIME COMPLEXITY:  O(n)
// SPACE COMPLEXITY: O(n)
