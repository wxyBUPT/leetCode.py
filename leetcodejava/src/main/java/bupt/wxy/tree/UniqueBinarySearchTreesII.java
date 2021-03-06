package bupt.wxy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/8/17.
 95. Unique Binary Search Trees II
 Difficulty: Medium

 Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class UniqueBinarySearchTreesII {

    // 21.60% 本题目可以使用dp,dp的两种方式也是空间换时间与时间换空间的转换
    public List<TreeNode> generateTrees(int n) {
        if(n==0)return new ArrayList<>();
        return recursive(1,n);
    }

    List<TreeNode> recursive(int i, int j){
        List<TreeNode> res=new LinkedList<>();
        if(i>j){
            res.add(null);
            return res;
        }
        if(i==j){
            res.add(new TreeNode(i));
            return res;
        }
        for(int k=i;k<=j;k++){
            List<TreeNode> lefts=recursive(i,k-1);
            List<TreeNode> rights=recursive(k+1,j);
            for(TreeNode left:lefts){
                for(TreeNode right:rights){
                    TreeNode root=new TreeNode(k);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
