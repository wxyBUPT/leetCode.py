package norecursion;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 1/3/17.
 129. Sum Root to Leaf Numbers   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 97765
 Total Submissions: 278680
 Difficulty: Medium
 Contributors: Admin
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class Solution_129 {
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> pre = new Stack<>();
        stack.push(root);
        pre.push(root.val);
        TreeNode node;
        Integer val;
        int res = 0;
        while (!stack.isEmpty()){
            node = stack.pop();
            val=pre.pop();
            if(node.left==null&&node.right==null)res+=val;
            else {
                if(node.left!=null){
                    stack.push(node.left);
                    pre.push(10*val+node.left.val);
                }
                if(node.right!=null){
                    stack.push(node.right);
                    pre.push(10*val+node.right.val);
                }
            }
        }
        return res;
    }
}