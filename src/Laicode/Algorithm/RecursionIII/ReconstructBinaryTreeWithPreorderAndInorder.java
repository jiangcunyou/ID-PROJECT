package Laicode.Algorithm.RecursionIII;

/*
* Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

preorder traversal = {5, 3, 1, 4, 8, 11}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?

We use the pre order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
* */

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPreorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        // Write your solution here
        Map<Integer, Integer> index = indexmap(inOrder);
        return helper(preOrder, index, 0, inOrder.length - 1, 0, preOrder.length - 1);
    }

    private Map<Integer, Integer> indexmap(int[] inOrder){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return map;
    }

    private TreeNode helper(int[] preOrder, Map<Integer, Integer> index, int inleft, int inright, int preleft, int preright){
        if(inleft > inright){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preleft]);
        int inmid = index.get(root.key);
        root.left = helper(preOrder, index, inleft, inmid - 1, preleft + 1, preleft + inmid - inleft);
        root.right = helper(preOrder, index, inmid + 1, inright, preright + inmid - inright + 1, preright);
        return root;
    }
}
