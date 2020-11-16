package ExtraCredit;

import Problem1.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
//I got the idea for this from https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/solution

public class KDistance {
    public static List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> target, int val) {
        // homework
        Stack<TreeNode> stack = new Stack<>();
        if (!findTargetHelper(root, target, stack)){
            return Collections.emptyList();
        }
        int count = 0;
        TreeNode lastNode = null;
        List<Integer> aux = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            aux.addAll(findChild(node, lastNode, val - count));
            count++;
            lastNode = node;
        }
        return aux;
    }
    public static boolean findTargetHelper(TreeNode root, TreeNode target, Stack<TreeNode> stack){
        if (root == null){
            return false;
        }
        stack.push(root);
        if (root == target){
            return true;
        }
        if (findTargetHelper(root.left, target, stack)){
            return true;
        }
        if (findTargetHelper(root.right, target, stack)){
            return true;
        }
        stack.pop();
        return false;
    }
    public static List<Integer> findChild(TreeNode root, TreeNode pre, int val){
        if (root == null || val < 0 || root == pre){
            return Collections.emptyList();
        }
        if (val == 0){
            return Arrays.asList((Integer) root.val);
        }
        List<Integer> aux = new ArrayList<>();
        aux.addAll(findChild(root.left, pre, val - 1));
        aux.addAll(findChild(root.right, pre, val - 1));
        return aux;
    }

}

