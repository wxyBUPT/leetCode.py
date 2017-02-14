package main.java.bupt.wxy.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiyuanbupt on 2/13/17.
 515. Find Largest Value in Each Tree Row
 Description  Submission  Solutions  Add to List
 Total Accepted: 1240
 Total Submissions: 2718
 Difficulty: Medium
 Contributors: love_FDU_llp
 You need to find the largest value in each row of a binary tree.

 Example:
 Input:

 1
 / \
 3   2
 / \   \
 5   3   9

 Output: [1, 3, 9]
 Subscribe to see which companies asked this question.
 */
public class FindLargestValueInEachTreeRow {

    // 14ms 做的时候还没有多少人提交
    public int[] largestValues(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        if(root==null)return new int[0];
        queue.offer(root);
        List<Integer> res=new LinkedList<>();
        while (!queue.isEmpty()){
            int len=queue.size();
            int max=Integer.MIN_VALUE;
            while (len!=0){
                TreeNode node=queue.poll();
                max=Math.max(max,node.val);
                len--;
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            res.add(max);
        }
        int[] ret=new int[res.size()];
        for(int i=0, size=res.size();i<size;i++){
            ret[i]=res.get(i);
        }
        return ret;
    }
}
