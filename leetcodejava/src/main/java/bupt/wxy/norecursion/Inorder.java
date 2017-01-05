package main.java.bupt.wxy.norecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiyuanbupt on 1/5/17.
 94. Binary Tree Inorder Traversal   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 169463
 Total Submissions: 387999
 Difficulty: Medium
 Contributors: Admin
 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Inorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inorder(root,res);
        return res;
    }

    void inorder(TreeNode root,List<Integer> res){
        if(root==null)return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    List<Integer> inorder(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while (!stack.isEmpty()||curr!=null){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        return res;
    }
}
