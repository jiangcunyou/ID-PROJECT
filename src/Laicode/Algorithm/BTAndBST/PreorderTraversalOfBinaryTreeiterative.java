package Laicode.Algorithm.BTAndBST;

/*
* Implement an iterative, pre-order traversal of a given binary tree,
* return the list of keys of each node in the tree as it is pre-order traversed.

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
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversalOfBinaryTreeiterative {
    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here
        List<Integer> preorder = new ArrayList<>();
        if (root == null){
            return preorder;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            if (cur.right != null){
                stack.offerFirst(cur.right);
            }
            if (cur.left != null){
                stack.offerFirst(cur.left);
            }
            preorder.add(cur.key);
        }
        return preorder;
    }
}

//Time complexity: O(n)
//Space complexity: O(height)