package Laicode.Algorithm.CrossTrainningI;

/*
* Given two nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

-There is no parent pointer for the nodes in the K-nary tree.

-The given two nodes are guaranteed to be in the K-nary tree.

Examples



        5

      /   \

     9   12

   / | \      \

 1 2   3      14



The lowest common ancestor of 2 and 14 is 5.

The lowest common ancestor of 2 and 9 is 9.


* */

public class LowestCommonAncestorV {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        // Write your solution here
        if (root == null || root == a || root == b){
            return root;
        }
        KnaryTreeNode found = null;
        for (KnaryTreeNode child :
                root.children) {
            KnaryTreeNode node = lowestCommonAncestor(child,a, b);
            if (node == null){
                continue;
            }
            if (found == null){
                found = node;
            }else {
                return root;
            }
        }
        return found;
    }

    //Time  Complexity: O(n)
    //Space Complexity: O(h + m)
}
