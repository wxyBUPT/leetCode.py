package main.java.bupt.wxy.norecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiyuanbupt on 1/5/17.
 */
public class PreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preorder(root,res);
        return res;
    }
    void preorder(TreeNode root, List<Integer> res){
        if(root==null)return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 非递归版本
     * @param root
     * @return
     */
    public List<Integer> preorder(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while (!stack.isEmpty()||curr!=null){
            while (curr!=null){
                // visit
                res.add(curr.val);
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            curr=curr.right;
        }
        return res;
    }
}
