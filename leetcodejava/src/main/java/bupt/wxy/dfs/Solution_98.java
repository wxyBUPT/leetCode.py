package main.java.bupt.wxy.dfs;

/**
 * Created by xiyuanbupt on 1/11/17.
 98. Validate Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 134186
 Total Submissions: 600851
 Difficulty: Medium
 Contributors: Admin
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
 1
 / \
 2   3
 Binary tree [1,2,3], return false.
 */
public class Solution_98 {

    public boolean isValidBST(TreeNode root) {
        return isBSTWithDepth(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    // 获得树的深度同时判断是否是合法的bst,如果不是合法bst返回-1,合法返回树的高度
    boolean isBSTWithDepth(TreeNode root, int start, int end){
        if(root==null)return true;
        if(root.val==Integer.MIN_VALUE&&root.left!=null)return false;
        if(root.val==Integer.MAX_VALUE&&root.right!=null)return false;
        if(root.val<start||root.val>end)return false;
        boolean left=isBSTWithDepth(root.left,start,root.val-1);
        boolean right=isBSTWithDepth(root.right,root.val+1,end);
        return left&&right;
    }
}
