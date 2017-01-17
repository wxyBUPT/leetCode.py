package main.java.bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 1/17/17.
 Facebook 面经题目, 求二叉树中leaf to leaf 最长长度
 */
public class LeafToLeafLongest {

    int maxValue;

    public int getLongest(TreeNode root){
        maxValue=Integer.MIN_VALUE;
        getLongestToLeaf(root);
        return maxValue;
    }

    // 获得到达leaf 的最长路径
    public int getLongestToLeaf(TreeNode root){
        if(root==null)return 0;
        int left=getLongestToLeaf(root.left);
        int right=getLongestToLeaf(root.right);
        maxValue=Math.max(maxValue,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
