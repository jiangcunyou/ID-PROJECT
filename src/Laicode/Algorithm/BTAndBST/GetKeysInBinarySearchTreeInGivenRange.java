package Laicode.Algorithm.BTAndBST;

/*
* Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

Corner Cases

What if there are no keys in the given range? Return an empty list in this case.
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

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBinarySearchTreeInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max){
        List<Integer> list = new ArrayList<>();
        getRange(root, min, max, list);
        return list;
    }

    public void getRange(TreeNode root, int min, int max, List<Integer> list){
        if (root == null){
            return;
        }
        if (root.key > min){
            getRange(root.left, min, max, list);
        }
        if (root.key >= min && root.key <= max){
            list.add(root.key);
        }
        if (root.key < max){
            getRange(root.right, min, max, list);
        }
    }
}

//Time complexity: O(n)
//Space complexity: O(height)