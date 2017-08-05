package bupt.wxy.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiyuanbupt on 7/31/17.
 * 637. Average of Levels in Binary Tree
 * DescriptionHintsSubmissionsDiscussSolution
 * Discuss Pick One
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * <p>
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>(128);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0.0;
            for(int i = 0; i<count; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(sum / count);
        }
        return res;
    }
}
