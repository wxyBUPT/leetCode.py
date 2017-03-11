package main.java.bupt.wxy.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiyuanbupt on 2/13/17.
 508. Most Frequent Subtree Sum
 Difficulty: Medium
 Given the root of a tree, you are asked to find the most frequent subtree sum.
 The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

 Examples 1
 Input:

 5
 /  \
 2   -3
 return [2, -3, 4], since all the values happen only once, return all of them in any order.
 Examples 2
 Input:

 5
 /  \
 2   -5
 return [2], since 2 happens twice, however -5 only occur once.
 Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

 Subscribe to see which companies asked this question.
 */
public class MostFrequentSubTree {

    // 65.54%
    Map<Integer, Integer> map=new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);
        int max=Integer.MIN_VALUE;
        for(int i:map.values()){
            max=Math.max(i,max);
        }
        List<Integer> res=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==max)res.add(entry.getKey());
        }
        int[] ret=new int[res.size()];
        for(int i=0;i<res.size();i++)ret[i]=res.get(i);
        return ret;
    }

    int getSum(TreeNode root){
        if(root==null)return 0;
        int left=getSum(root.left), right=getSum(root.right);
        int res=left+right+root.val;
        map.put(res,map.getOrDefault(res,0)+1);
        return res;
    }
}
