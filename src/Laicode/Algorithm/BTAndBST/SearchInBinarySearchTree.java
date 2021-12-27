package Laicode.Algorithm.BTAndBST;

/*
* Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.

Assumptions

There are no duplicate keys in the binary search tree
* */

public class SearchInBinarySearchTree {
    public TreeNode search(TreeNode root, int key) {
        // Write your solution here
        if (root == null || root.key == key){
            return root;
        }else if (root.key > key){
            return search(root.left, key);
        }else {
            return search(root.right, key);
        }
    }
}

//Time complexity:  for balanced BST O(logn) worst case O(n)
//Space complexity: O(height)