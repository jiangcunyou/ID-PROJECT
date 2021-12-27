package Laicode.Algorithm.BTAndBST;

/*
* Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

In-order traversal is [1, 3, 4, 5, 8, 11]

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

public class InorderTraversalOfBinaryTreeiterative {
    public List<Integer> inOrder(TreeNode root) {
        // Write your solution here
        List<Integer> inOrder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            }else {
                cur = stack.pollFirst();
                inOrder.add(cur.key);
                cur = cur.right;
            }
        }
        return inOrder;
    }
}

//Time complexity: O(n)
//Space complexity: O(height)
