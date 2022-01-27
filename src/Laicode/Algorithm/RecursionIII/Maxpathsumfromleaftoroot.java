package Laicode.Algorithm.RecursionIII;

/*
* Given a binary tree in which each node contains an integer number. Find the maximum possible path sum from a leaf to root.



Assumptions

The root of given binary tree is not null.



Examples



         10

       /      \

    -2        7

  /     \

8      -4

The maximum path sum is 10 + 7 = 17.
* */

public class Maxpathsumfromleaftoroot {
    public int maxPathSumLeafToRoot(TreeNode root) {
        // Write your solution here
        if (root == null){
            return 0;
        }

        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum){
        sum += root.key;
        if (root.left == null && root.right == null){
            return sum;
        }else if (root.left == null){
            return helper(root.right, sum);
        }else if (root.right == null){
            return helper(root.left, sum);
        }
        return Math.max(helper(root.left, sum), helper(root.right, sum));
    }
}

//TC: O(n)
//SC: O(h)