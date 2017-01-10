package main.java.bupt.wxy.tree;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 1/10/17.
 105. Construct Binary Tree from Preorder and Inorder Traversal   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 86391
 Total Submissions: 281260
 Difficulty: Medium
 Contributors: Admin
 Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class Solution_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    TreeNode buildTree(int[] preorder, int pr_lo,int pr_hi, int[] inorder, int in_lo, int in_hi){
        if(pr_lo>pr_hi)return null;
        TreeNode root=new TreeNode(preorder[pr_lo]);
        if(pr_hi==pr_lo)return root;
        int in_mid=in_lo;
        for(int i=in_lo;i<=in_hi;i++){
            if(inorder[i]==preorder[pr_lo]){
                in_mid=i;
                break;
            }
        }
        int l_l=in_mid-in_lo;
        root.left=buildTree(preorder, pr_lo+1,pr_lo+l_l, inorder, in_lo,in_mid-1);
        root.right=buildTree(preorder,pr_lo+l_l+1,pr_hi, inorder, in_mid+1,in_hi);
        return root;
    }


    public static void main(String[] args){
        int[] nums={1,2,3,4};
        System.out.println(Arrays.binarySearch(nums,0,1,1));
    }
}
