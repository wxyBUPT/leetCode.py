package main.java.bupt.wxy.bfs;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/8/17.
 103. Binary Tree Zigzag Level Order Traversal
 Difficulty: Medium

 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    // 本题目其实有很多种方法
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int levelSize=0;
        boolean inc=true;
        while (!queue.isEmpty()){
            levelSize=queue.size();
            List<Integer> levelVals=new LinkedList<>();
            TreeNode tmp;
            inc=!inc;
            for(int i=0;i<levelSize;i++){
                tmp=queue.poll();
                if(inc) {
                    levelVals.add(0, tmp.val);
                }else {
                    levelVals.add(tmp.val);
                }
                if(tmp.left!=null)queue.offer(tmp.left);
                if(tmp.right!=null)queue.offer(tmp.right);
            }
            res.add(levelVals);
        }
        return res;
    }
}
