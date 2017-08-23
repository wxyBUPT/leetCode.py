package bupt.wxy.tree;

import java.util.*;

/**
 * Created by xiyuanbupt on 2/28/17.
 102. Binary Tree Level Order Traversal Add to List
 Description  Submission  Solutions
 Total Accepted: 155094
 Total Submissions: 411481
 Difficulty: Medium
 Contributors: Admin
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class BinaryTreeLevelOrderTraversal {
    // 12.69%
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                level_left--;
                node=queue.poll();
                this_level.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            res.add(this_level);
        }
        return res;
    }
}
