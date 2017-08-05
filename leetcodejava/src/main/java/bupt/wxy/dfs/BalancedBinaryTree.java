package bupt.wxy.dfs;

/**
 * Created by xiyuanbupt on 3/2/17.
 110. Balanced Binary Tree Add to List
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {

    // 25.72%
    public boolean isBalanced(TreeNode root) {
        return isBalancedWithDepth(root)!=-1;
    }

    public int isBalancedWithDepth(TreeNode root){
        if(root==null)return 0;
        int right=isBalancedWithDepth(root.right);
        int left=isBalancedWithDepth(root.left);
        if(right==-1||left==-1)return -1;
        if(Math.abs(right-left)>1)return -1;
        return 1+Math.max(right,left);
    }
}
