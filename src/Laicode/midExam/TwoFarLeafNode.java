package Laicode.midExam;

/*
* Given a binary tree in which each node contains an int number.

Find the maximum possible sum from any leaf node to another leaf node.

The maximum sum path may or may not go through root.

Expected time complexity is O(n).
* */

public class TwoFarLeafNode {
    public class TreeNode{
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key){
            this.key = key;
        }
    }

    public int postOrder(TreeNode root, int[] res) {

        if (root == null){
            return 0;
        }
        int leftsum = postOrder(root.left, res);
        int rightsum = postOrder(root.right, res);
        //case 1: if current root has both left and right child.
        //then update the result and choose the bigger sum between the left and right child
        if (root.left != null && root.right != null){
            res[0] = Math.max(root.key + leftsum + rightsum, res[0]);
            return Math.max(root.key + leftsum, root.key + rightsum);
        }
        //case 2: if one chile exist, return the one with leaf.
        if (root.left == null) return root.key + rightsum;
        return root.key + leftsum;
    }

    public int maxPathsum(TreeNode root){
        if (root == null || root.left == null || root.right == null){
            return Integer.MIN_VALUE;
        }
        int[] res = {Integer.MIN_VALUE};
        postOrder(root, res);
        return res[0];
    }

}

//Time Complexity:  O(n)
//Space Complexity: o(n)

