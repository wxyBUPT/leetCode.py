package main.java.bupt.wxy.dfs;

/**
 * Created by xiyuanbupt on 1/3/17.
 129. Sum Root to Leaf Numbers
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
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int pre){
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 10*pre+root.val;
        return dfs(root.left, 10*pre+root.val) + dfs(root.right, 10*pre+root.val);
    }
}