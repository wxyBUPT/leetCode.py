package main.java.bupt.wxy.tree;

import java.util.*;

/**
 * Created by xiyuanbupt on 2/28/17.
 101. Symmetric Tree Add to List
 Difficulty: Easy

 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3

 */
public class SymmetricTree {

    // 23.55%
    public boolean isSymmetric(TreeNode root) {
        return root==null||isSymmetricHlep(root.left,root.right);
    }

    boolean isSymmetricHlep(TreeNode left, TreeNode right){
        if(left==null||right==null)return left==right;
        if(left.val!=right.val)return false;
        return isSymmetricHlep(left.left,right.right)&&isSymmetricHlep(left.right,right.left);
    }

    // 12.86%
    public boolean isSymmetric1(TreeNode root) {

        List<TreeNode> nodes=new ArrayList<>();
        if(root==null)return true;
        boolean left_null=root.left==null, right_null=root.right==null;
        if(left_null&&right_null)return true;
        if(left_null||right_null) return false;
        nodes.add(root.left);
        nodes.add(root.right);
        // 层序遍历
        while (!nodes.isEmpty()){
            int len=nodes.size();
            // 判断这层数值相同,并且下一层位置相同
            int i=0,j=len-1;
            while (i<j){
                TreeNode left=nodes.get(i++);
                TreeNode right=nodes.get(j--);
                if(left.val!=right.val)return false;
                // 判断位置对称
                if(right.right==null||left.left==null){
                    if(right.right!=null||left.left!=null)return false;
                }
                if((right.left==null||left.right==null)&&(right.left!=null||left.right!=null))return false;
            }
            // 层序遍历
            for(int k=0;k<len;k++){
                TreeNode curr=nodes.remove(0);
                if(curr.left!=null)nodes.add(curr.left);
                if(curr.right!=null)nodes.add(curr.right);
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(null==null);
    }
}
