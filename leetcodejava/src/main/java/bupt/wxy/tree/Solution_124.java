package main.java.bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 1/16/17.
 124. Binary Tree Maximum Path Sum   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 84457
 Total Submissions: 337163
 Difficulty: Hard
 Contributors: Admin
 Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.


 */
public class Solution_124 {

    int maxValue;
    // 20.70%
    public int maxPathSum(TreeNode root){
        maxValue=Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    int maxPathDown(TreeNode node){
        if(node==null)return 0;
        int left=Math.max(0,maxPathDown(node.left));
        int right=Math.max(0,maxPathDown(node.right));
        maxValue=Math.max(maxValue,left+right+node.val);
        return Math.max(left,right)+node.val;
    }

}
