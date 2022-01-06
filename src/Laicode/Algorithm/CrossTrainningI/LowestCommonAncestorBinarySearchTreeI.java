package Laicode.Algorithm.CrossTrainningI;

/*
* Given two keys in a binary search tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary search tree

There are no duplicate keys in the binary search tree

The given two nodes are guaranteed to be in the binary search tree

Examples

        5

      /   \

     2     12

   /  \      \

  1    3      14

The lowest common ancestor of 1 and 14 is 5

The lowest common ancestor of 1 and 3 is 2
* */

public class LowestCommonAncestorBinarySearchTreeI {
    public TreeNode lca(TreeNode root, int p, int q) {
        // Write your solution here
        int small = Math.min(p, q);
        int large = Math.max(p, q);
        while (root != null){
            if (root.key > large){
                root = root.left;
            }else if (root.key < small){
                root = root.right;
            }else
                return root;
        }
        return null;
    }

    //Time  Complexity: avg: O(logn) worst: O(n)
    //Space Complexity: O(1)
}
