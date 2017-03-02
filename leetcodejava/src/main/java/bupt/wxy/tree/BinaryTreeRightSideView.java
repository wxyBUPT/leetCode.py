package main.java.bupt.wxy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 3/1/17.
 199. Binary Tree Right Side View Add to List
 Description  Submission  Solutions
 Total Accepted: 70743
 Total Submissions: 180024
 Difficulty: Medium
 Contributors: Admin
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].


 */
public class BinaryTreeRightSideView {

    // 首先想到的是使用层序遍历, 但是更加节省空间的办法是考虑利用二叉树各种遍历的状态
    // 78.21%
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        dfs(root,res,0);
        return res;
    }

    void dfs(TreeNode root, List<Integer> res, int depth){
        // 跳过为空的点
        if(root==null)return;
        if(depth==res.size()){
            res.add(root.val);
        }
        dfs(root.right,res,depth+1);
        dfs(root.left,res,depth+1);
    }
}
