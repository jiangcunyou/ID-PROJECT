package Laicode.Algorithm.CrossTrainningI;

/*
* Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
* */

public class LowestCommonAncestorII {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here.
        int l1 = length(one);
        int l2 = length(two);
        if (l1 >= l2){
            return merge(two, one, l1 - l2);
        }else {
            return merge(one, two, l2 - l1);
        }
    }

    private TreeNodeP merge(TreeNodeP small, TreeNodeP large, int diff){
        while (diff > 0){
            large = large.parent;
            diff--;
        }
        while (large != small){
            large = large.parent;
            small = small.parent;
        }
        return large;
    }

    private int length(TreeNodeP node){
        int length = 0;
        while (node != null){
            length++;
            node = node.parent;
        }
        return length;
    }
    //Time  Complexity: O(n)
    //Space Complexity: O(1)
}
