package main.java.bupt.wxy.tree;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 1/15/17.
 99. Recover Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 65796
 Total Submissions: 229091
 Difficulty: Hard
 Contributors: Admin
 Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 Subscribe to see which companies asked this question
 */

/**
 * 其实本算法也可以使用二叉树的递归算法
 */
public class Solution_99 {

    // 二叉树的非递归中序比那里
    public void recoverTree(TreeNode root) {

        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        TreeNode pre=new TreeNode(Integer.MIN_VALUE);
        // a 存储错位后值较大的点
        TreeNode a=null,b=null;

        while (curr!=null||!stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();

            TreeNode left=pre;


            TreeNode right=curr.right;
            while (right!=null&&right.left!=null)right=right.left;
            if(right==null&&!stack.isEmpty())right=stack.peek();
            else if(right==null)right=new TreeNode(Integer.MAX_VALUE);

            // 没找到b才能找a
            if(b==null&&curr.val>left.val&&curr.val>right.val)a=curr;
            // 找到a才能继续找b
            if(a!=null&&curr.val<left.val&&curr.val<right.val)b=curr;
            pre=curr;
            curr=curr.right;

        }
        if(a!=null&&b!=null){
            int tmp=a.val;
            a.val=b.val;
            b.val=tmp;
        }

    }
}
