package Laicode.Algorithm.RecursionII;

/*
* Given a binary tree, count the number of nodes in each node’s left subtree, and store it in the numNodesLeft field.

Examples

 

                  1(6)

               /          \

           2(3)        3(0)

          /      \

      4(1)     5(0)

    /        \        \

6(0)     7(0)   8(0)

The numNodesLeft is shown in parentheses.
* */


public class StoreNumberOfNodesInLeftSubtree {
    public void numNodesLeft(TreeNodeLeft root) {
        // Write your solution here
        numnodes(root);
    }
    private int numnodes(TreeNodeLeft root){
        if (root == null){
            return 0;
        }
        int leftNum = numnodes(root.left);
        int rightNum = numnodes(root.right);
        root.numNodesLeft = leftNum;
        return leftNum + rightNum + 1;
    }
}

//Time Complexity:  O(# of nodes)
//Space Complexity: O(height)