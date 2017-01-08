package main.java.bupt.wxy.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/8/17.
 95. Unique Binary Search Trees II   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 72373
 Total Submissions: 236724
 Difficulty: Medium
 Contributors: Admin
 Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class Solution_95 {

    // 本题目如果不使用dp, 将会非常耗时
    // 返回有多少颗树可以使用dp,创建所有的树还是第一次看见
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp=new List[n+1];
        dp[0]=new ArrayList<>();
        if(n==0)return dp[0];
        dp[0].add(null);


        for(int len=1;len<=n;len++){
            dp[len]=new LinkedList<>();
            for(int j=0;j<len;j++){
                for(TreeNode nodeL:dp[j]){
                    for(TreeNode nodeR:dp[len-j-1]){
                        TreeNode node=new TreeNode(j+1);
                        node.left=nodeL;
                        node.right=clone(nodeR,j+1);
                        dp[len].add(node);
                    }
                }
            }
        }
        return dp[n];
    }

    static TreeNode clone(TreeNode n, int offset){
        if(n==null)return n;
        TreeNode node=new TreeNode(n.val+offset);
        node.left=clone(n.left,offset);
        node.right=clone(n.right,offset);
        return node;
    }
}
