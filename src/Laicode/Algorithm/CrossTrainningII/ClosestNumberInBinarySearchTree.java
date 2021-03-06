package Laicode.Algorithm.CrossTrainningII;

/*
* In a binary search tree, find the node containing the closest number to the given target number.

Assumptions:

The given root is not null.
There are no duplicate keys in the binary search tree.
Examples:

    5

  /    \

2      11

     /    \

    6     14

closest number to 4 is 5

closest number to 10 is 11

closest number to 6 is 6

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

public class ClosestNumberInBinarySearchTree {
    public int closest(TreeNode root, int target) {
        // Write your solution here
        int result = root.key;
        while (root != null){
            if (root.key == target){
                return result;
            }
            else if (Math.abs(root.key - target) < Math.abs(result - target)){
                result = root.key;
            }
            if (root.key < target){
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return result;
    }

    //TC:  Avg O(logn) worst O(n)
    //SC:   O(1)
}
