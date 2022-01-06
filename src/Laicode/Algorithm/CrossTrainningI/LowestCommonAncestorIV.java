package Laicode.Algorithm.CrossTrainningI;

/*
* Given K nodes in a binary tree, find their lowest common ancestor.

Assumptions

K >= 2

There is no parent pointer for the nodes in the binary tree

The given K nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2, 3, 14 is 5

The lowest common ancestor of 2, 3, 9 is 9
* */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestorIV {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // Write your solution here.
        Set<TreeNode> set = new HashSet<>(nodes);

        return helper(root, set);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set){
        if (root == null){
            return null;
        }
        if (set.contains(root)){
            return root;
        }
        TreeNode l = helper(root.left, set);
        TreeNode r = helper(root.right,set);
        if(l != null && r != null){
            return root;
        }
        return l != null ? l : r;
    }
    //Time  Complexity: O(n)
    //Space Complexity: O(h + k)
}
