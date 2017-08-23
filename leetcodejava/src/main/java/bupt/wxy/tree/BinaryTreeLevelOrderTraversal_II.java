package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 3/1/17.
 107. Binary Tree Level Order Traversal II
 Difficulty: Easy
 Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */

import java.util.*;

/**
 * 层序遍历的变种
 */
public class BinaryTreeLevelOrderTraversal_II {

    // 10.87%
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null)return res;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        // 使用null代表一层的结束
        while (queue.size()>0){
            int level_left=queue.size();
            List<Integer> this_level=new ArrayList<>(level_left);
            TreeNode node;
            while (level_left>0){
                System.out.println("我就是想看着不同");
                level_left--;
                node=queue.poll();
                this_level.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            res.add(0,this_level);
        }
        return res;
    }
}
