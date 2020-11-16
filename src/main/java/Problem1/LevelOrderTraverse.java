package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//I got the idea for this from https://lenchen.medium.com/leetcode-102-binary-tree-level-order-traversal-433da88bdfed
public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        // homework

            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;
            Queue<TreeNode> aux = new LinkedList<>();
            aux.add(root);

            while(!aux.isEmpty()){
                int cnt = aux.size();
                List<Integer> level = new ArrayList<>(cnt);

                for(int i = 0; i < cnt; i++){
                    TreeNode node = aux.poll();
                    level.add((Integer)node.val);
                    if(node.left != null)
                        aux.add(node.left);
                    if(node.right != null)
                        aux.add(node.right);
                }
                result.add(level);
            }
            return result;

    }
}
