package Laicode.Algorithm.BTAndBST;

/*
* Delete the target key K in the given binary search tree if the binary search tree contains K. Return the root of the binary search tree.

Find your own way to delete the node from the binary search tree, after deletion the binary search tree's property should be maintained.

Assumptions

There are no duplicate keys in the binary search tree

The smallest larger node is first candidate after deletion
* */

public class DeleteInBinarySearchTree {
    public TreeNode deleteTree(TreeNode root, int key) {
        // Write your solution here
        if (root == null){
            return null;
        }
        if (key == root.key){
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else if (root.right.left == null){
                root.right.left = root.left;
                return root.right;
            }else {
                TreeNode newRoot = deleteSmallest(root.right);
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }
        if (key < root.key){
            root.left = deleteTree(root.left, key);
        }else if (key > root.key){
            root.right = deleteTree(root.right, key);
        }
        return root;
    }

    public TreeNode deleteSmallest(TreeNode root){
        while(root.left.left != null){
            root = root.left;
        }
        TreeNode smallest = root.left;
        root.left = root.left.right;
        return smallest;
    }


}

//Time complexity: For balanced BST O(logn) worst case O(n)
//Space complexity: O(1)