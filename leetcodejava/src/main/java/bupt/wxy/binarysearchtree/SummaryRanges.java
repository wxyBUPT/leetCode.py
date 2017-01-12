package main.java.bupt.wxy.binarysearchtree;

/**
 * Created by xiyuanbupt on 1/12/17.
 352. Data Stream as Disjoint Intervals   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 9551
 Total Submissions: 24584
 Difficulty: Hard
 Contributors: Admin
 Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

 For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

 [1, 1]
 [1, 1], [3, 3]
 [1, 1], [3, 3], [7, 7]
 [1, 3], [7, 7]
 [1, 3], [6, 7]

 Follow up:
 What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */

import java.util.*;

/**
 * 先不考虑Followup
 */

class Interval{
    int start;
    int end;
    Interval(){start=0;end=0;}
    Interval(int s,int e){
        start=s;
        end=e;
    }
}

// 42.57%
public class SummaryRanges {

    // 题目已经有所提醒, 应该想如何充分的利用到二叉搜索树
    TreeMap<Integer,Interval> tree;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree=new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val))return;
        Integer l=tree.lowerKey(val);
        Integer h=tree.higherKey(val);
        if(l!=null&&h!=null&&tree.get(l).end+1==val&&val+1==h){
            tree.get(l).end=tree.get(h).end;
            tree.remove(h);

        }
        // 与左面相连或者被包含在左面
        else if(l!=null&&tree.get(l).end+1>=val){
            tree.get(l).end=Math.max(tree.get(l).end,val);
        }
        // 与右面相连
        else if(h!=null&&h==val+1){
            tree.put(val, new Interval(val,tree.get(h).end));
            tree.remove(h);
        }else {
            tree.put(val,new Interval(val,val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }

    /**
    // 3.01% 不知道为什么只击败了 3.01%
    // 但是后续想想线段树相关内容, 就理解为什么不是最优的了, get 的时间复杂度为 On 甚至比使用数组更加糟糕
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    TreeNode root;
    public SummaryRanges() {

    }

    public void addNum(int val) {
        root=addNum(val,root);
    }

    TreeNode addNum(int val, TreeNode root){
        if(root==null)return new TreeNode(val);
        else if(val==root.val)return root;
        else if(val<root.val)root.left=addNum(val,root.left);
        else root.right=addNum(val,root.right);
        return root;
    }

    public List<Interval> getIntervals() {
        // 二叉树中序非递归遍历
        List<Interval> res=new LinkedList<>();
        Interval preInterval=new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while (curr!=null||!stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            // 访问当前节点
            curr=stack.pop();
            //断掉的情况执行更新
            if(curr.val!=preInterval.end+1){
                res.add(preInterval);
                preInterval=new Interval(curr.val,curr.val);
            }
            // 连续的情况也需要更新
            else {
                preInterval.end++;
            }

            curr=curr.right;
        }
        res.remove(0);
        res.add(preInterval);
        return res;

    }
    **/
}
