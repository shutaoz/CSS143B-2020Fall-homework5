package Problem2;

import Problem1.TreeNode;
//I got the idea for this assignment from https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/335789/Java-solution
public class LCA {
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // homework
        // hint: pay attention to the assumptions of this problem.
        if (root == null || root == p || root == q) return root;
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);
        if(L == null && R == null) return null;
        if(L != null && R != null) return root;

        return L == null ? R : L;
    }
}
