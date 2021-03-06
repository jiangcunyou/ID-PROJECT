package Laicode.Algorithm.RecursionIII;

/*
* Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

Assumptions

The given sequence is not null
There are no duplicate keys in the binary search tree
Examples

postorder traversal = {1, 4, 3, 11, 8, 5}

the corresponding binary search tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

* */

public class ReconstructBinarySearchTreeWithPostorderTraversal {
    public TreeNode reconstruct(int[] post) {
        // Write your solution here
        int[] index = new int[]{post.length - 1};
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] post, int[] index, int min){
        if (index[0] < 0 || post[index[0]] <= min){
            return null;
        }
        TreeNode root = new TreeNode(post[index[0]]--);
        root.right = helper(post, index, root.key);
        root.left = helper(post, index, min);
        return root;
    }
}
