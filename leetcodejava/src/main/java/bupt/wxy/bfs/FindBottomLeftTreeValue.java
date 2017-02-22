package main.java.bupt.wxy.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiyuanbupt on 2/13/17.
 513. Find Bottom Left Tree Value
 Difficulty: Medium

 Given a binary tree, find the leftmost value in the last row of the tree.

 Example 1:
 Input:

 2
 / \
 1   3

 Output:
 1
 Example 2:
 Input:

 1
 / \
 2   3
 /   / \
 4   5   6
 /
 7

 Output:
 7
 Note: You may assume the tree (i.e., the given root node) is not NULL.

 Subscribe to see which companies asked this question.
 */
public class FindBottomLeftTreeValue {


    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            int len=queue.size();
            res=queue.peek().val;
            while (len!=0){
                TreeNode node=queue.poll();
                len--;
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
        }
        return res;
    }
}
