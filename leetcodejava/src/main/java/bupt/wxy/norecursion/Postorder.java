package main.java.bupt.wxy.norecursion;

/**
 * Created by xiyuanbupt on 1/5/17.
 145. Binary Tree Postorder Traversal   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 124152
 Total Submissions: 323903
 Difficulty: Hard
 Contributors: Admin
 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 几个遍历最难的一个
 */
public class Postorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        postorder(root, res);
        return res;
    }

    void postorder(TreeNode root, List<Integer> res){
        if(root==null)return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // 利用了后续遍历的性质, 但是总觉得不算后续遍历
    // 如果只是后续访问, 可以看成从右到左的前序遍历
    // 但是不能应用到非递归找路径这种问题
    List<Integer> postordersimple(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                res.addFirst(root.val);;
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return res;
    }

    List<Integer> postorder(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        TreeNode curr=root;
        while (curr!=null||!stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            while (!stack.isEmpty()&&curr==stack.peek().right){
                curr= stack.pop();
                res.add(curr.val);
            }
            if(stack.empty())curr=null;
            else curr= stack.peek().right;
        }
        return res;
    }

    // 执行效率更高的解法,叶子节点就不入栈了
    public List<Integer> postorderTraversalImproved(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode cur = root;

        while (cur != null || !s.empty()) {
            while (!isLeaf(cur)) {
                s.push(cur);
                cur = cur.left;
            }

            if (cur != null) ans.add(cur.val);

            while (!s.empty() && cur == s.peek().right) {
                cur = s.pop();
                ans.add(cur.val);
            }

            if (s.empty()) cur = null; else cur = s.peek().right;
        }

        return ans;
    }

    private boolean isLeaf(TreeNode r) {
        if (r == null) return true;
        return r.left == null && r.right == null;
    }
}
