package Problem3;

import Problem1.TreeNode;

//I got the idea for this from https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/297878/Java-or-Iterative
public class InsertInBST {
    public static void insert(TreeNode<Integer> root, int valToInsert) {
        // homework

        TreeNode current = root;
        TreeNode base = null;

        while(current != null){
            base = current;
            if((int)current.val > valToInsert)
                current = current.left;
            else current = current.right;
        }

        if((int)base.val > valToInsert)
            base.left = new TreeNode(valToInsert);
        else
            base.right = new TreeNode(valToInsert);
    }

}
