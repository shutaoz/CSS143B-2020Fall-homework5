package Problem1;

import java.util.ArrayList;
import java.util.List;

//I got the idea for this assignment from https://cheonhyangzhang.wordpress.com/2015/09/29/94-leetcode-java-binary-tree-inorder-traversal-medium/
import java.util.Stack;
public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        // homework
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if(current.left == null && current.right == null){
                result.add((Integer) current.val);
                continue;
            }


            if(current.right != null) {
                stack.push(current.right);
            }

            stack.push(current);

            if(current.left != null) {
                stack.push(current.left);
            }

            current.left = null;
            current.right = null;
        }

        return result;
    }

}
