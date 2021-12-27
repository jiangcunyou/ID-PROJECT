package Laicode.Algorithm.BFS;

/*
* Check if a given binary tree is completed. A complete binary tree is one in which every level of
* the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.

Examples

        5

      /    \

    3        8

  /   \

1      4

is completed.

        5

      /    \

    3        8

  /   \        \

1      4        11

is not completed.

Corner Cases

What if the binary tree is null? Return true in this case.
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


import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsCompleted {
    public static boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left == null){
                flag = true;
            }else if (flag){
                return false;
            }else {
                queue.offer(cur.left);
            }
            if (cur.right == null){
                flag = true;
            }else if (flag){
                return false;
            }else {
                queue.offer(cur.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode role = new TreeNode(2);
        TreeNode rori = new TreeNode(1);
        TreeNode rolele = new TreeNode(5);

        root.left = role;
        root.right = rori;
        role.right = rolele;

        boolean i = isCompleted(root);
        System.out.println(i);
    }
}
