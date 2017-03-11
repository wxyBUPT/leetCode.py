package main.java.bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 2/26/17.
 530. Minimum Absolute Difference in BST My SubmissionsBack To Contest
 Difficulty: Easy
 Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

 1
 \
 3
 /
 2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 */

// 利用中序遍历
public class MinimumAbsoluteDifferenceInBST {

    int pre=Integer.MIN_VALUE;
    long res=Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        inOrder(root);
        return (int)res;
    }

    private void inOrder(TreeNode root){

        if(root==null)return;
        inOrder(root.left);
        long dist = (long)root.val-(long)pre;
        res = Math.min(res, dist);
        pre=root.val;
        inOrder(root.right);
    }
}
