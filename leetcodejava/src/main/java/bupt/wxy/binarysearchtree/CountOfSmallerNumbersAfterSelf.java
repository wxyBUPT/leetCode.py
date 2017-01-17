package main.java.bupt.wxy.binarysearchtree;

/**
 * Created by xiyuanbupt on 1/12/17.
 315. Count of Smaller Numbers After Self
 Total Accepted: 25082
 Total Submissions: 74817
 Difficulty: Hard
 Contributors: Admin
 You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].

 Subscribe to see which companies asked this question

 Hide Tags Divide and Conquer Binary Indexed Tree Segment Tree Binary Search Tree
 Show Similar Problems
 */

import java.util.*;

/**
 * 这么多标签中我只想到了二叉查找
 * 找到数值应该被插入的点
 */
public class CountOfSmallerNumbersAfterSelf {

    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

    // 69.38%
    // 这种算法还没有懂,之后想想
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }

    // 22.32% 58ms 从时间分布上看肯定有更好的办法
    public List<Integer> countSmaller22(int[] nums) {
        Integer[] counts=new Integer[nums.length];
        List<Integer> sorted=new ArrayList<>(nums.length);
        for(int i=nums.length-1;i>=0;i--){
            int index=binarySearch(sorted,nums[i]);
            counts[i]=index;
            sorted.add(index,nums[i]);
        }
        return Arrays.asList(counts);
    }

    // 数组是从大到小排列的, 找到左插入位置
    int binarySearch(List<Integer> nums, int target){
        int lo=0,hi=nums.size();
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums.get(mid)<target)lo=mid+1;
            else hi=mid;
        }
        return lo;
    }
    // but 超时!!!!!
    // 算是正常思维的一种方法,但是方法不算好
    public List<Integer> countSmallerTimeLimit(int[] nums) {
        Integer[] counts=new Integer[nums.length];
        for(int i=0;i<nums.length;i++)counts[i]=0;
        TreeMap<Integer, List<Integer>> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            for(Map.Entry<Integer,List<Integer>> entry:map.tailMap(nums[i],false).entrySet()){
                for(Integer index:entry.getValue()){
                    counts[index]++;
                }
            }
            if(!map.containsKey(nums[i]))map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        return Arrays.asList(counts);
    }
}
