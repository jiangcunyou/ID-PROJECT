package Laicode.Algorithm.RecursionII;

/*
* Given two nodes in a binary tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9
* */

public class LowestCommonAncestorI {
    //return:
    //null - there is no one or two in subtree
    //non null-
    //1#. if there is only one node of one/ two in the subtree,
    //  just return the one/two itself.
    //2#. if there both one/ two in the subtree, return LCA
    //  a#. one is two's ancestor, return one
    //  b#. two is one's ancestor, return two
    //  c#. otherwise, return the lowest node with one and two in the two different subtrees.

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // Write your solution here.
        if(root == null){
            return null;
        }
        if(root == one || root == two){
            return root;
        }
        TreeNode ll = lowestCommonAncestor(root.left, one, two);
        TreeNode lr = lowestCommonAncestor(root.right, one, two);
        if(ll != null && lr != null){
            return root;
        }
        return ll == null ? lr : ll;
    }

    public static void main(String[] args) {

    }
}

//Time complexity:  O(# of the nodes)
//Space complexity: O(height of the tree)
