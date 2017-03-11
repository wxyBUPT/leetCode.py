package main.java.bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 3/1/17.
 111. Minimum Depth of Binary Tree Add to List
 Description  Submission  Solutions
 Difficulty: Easy
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

    // 使用层序遍历可以实现, 试试递归实现
    // 19.47%
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return 1;
        if(root.left!=null&&root.right!=null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }else if(root.left==null){
            return 1+minDepth(root.right);
        }else {
            return 1+minDepth(root.left);
        }

    }
}
