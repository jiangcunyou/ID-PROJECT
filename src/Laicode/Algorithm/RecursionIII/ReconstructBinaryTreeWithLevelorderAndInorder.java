package Laicode.Algorithm.RecursionIII;

/*
* Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

levelorder traversal = {5, 3, 8, 1, 4, 11}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

        5

      /    \

    3        8

  /   \        \

1      4        11


* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructBinaryTreeWithLevelorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        // Write your solution here
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        for (int num :
                levelOrder) {
            list.add(num);
        }

        return helper(list, map);
    }

    private TreeNode helper(List<Integer> list, Map<Integer, Integer> map) {
        if (list.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(list.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num :
                list) {
            if (map.get(root.key) > map.get(num)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        root.left = helper(left, map);
        root.right = helper(right, map);
        return root;
    }
}
