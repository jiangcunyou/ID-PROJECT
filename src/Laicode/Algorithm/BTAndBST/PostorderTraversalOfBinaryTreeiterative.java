package Laicode.Algorithm.BTAndBST;

/*
* Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Post-order traversal is [1, 4, 3, 11, 8, 5]

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

import java.util.*;

public class PostorderTraversalOfBinaryTreeiterative {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        List<Integer> preOrder = new ArrayList<>();
        if (root == null){
            return preOrder;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();

            if (cur.left != null){
                stack.offerFirst(cur.left);
            }
            if (cur.right != null){
                stack.offerFirst(cur.right);
            }
            preOrder.add(cur.key);
        }
        Collections.reverse(preOrder);
        return preOrder;
    }
}

//Time complexity: O(n)
//Space complexity: O(height)
