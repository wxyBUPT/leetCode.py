package main.java.bupt.wxy.binarysearchtree;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by xiyuanbupt on 1/11/17.
 220. Contains Duplicate III   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 45167
 Total Submissions: 231087
 Difficulty: Medium
 Contributors: Admin
 Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */

/**
 * 首先本题目正常的想法是遍历数组, 对每一个值的后面k个元素与前面的值比较, 看是否满足条件
 * 最坏的时间复杂度是 O n*k*k
 * 避免不必要的比较之后时间复杂度可以提升为 O n*k
 * 使用平衡二叉树之后,时间复杂度可以提升为 O n* log(k)
 */
public class Solution_220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1||t<0)return false;
        SortedSet<Integer> set=new TreeSet<>();
        for(int i=0;i<k&&i<nums.length;i++){
            int start,end;

            if(Integer.MIN_VALUE+t>nums[i])start=Integer.MIN_VALUE;
            else start=nums[i]-t;
            if(Integer.MAX_VALUE-t-1<nums[i])end=Integer.MAX_VALUE;
            else end=nums[i]+t+1;


            if(set.subSet(start,end).size()!=0)return true;
            set.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            int start,end;
            if(Integer.MIN_VALUE+t>nums[i])start=Integer.MIN_VALUE;
            else start=nums[i]-t;
            if(Integer.MAX_VALUE-t-1<nums[i])end=Integer.MAX_VALUE;
            else end=nums[i]+t+1;

            if(set.subSet(start,end).size()!=0)return true;
            set.add(nums[i]);
            set.remove(nums[i-k]);
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(Integer.MIN_VALUE);
    }

}
