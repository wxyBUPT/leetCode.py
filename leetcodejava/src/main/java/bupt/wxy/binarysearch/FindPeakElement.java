package main.java.bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 3/1/17.
 162. Find Peak Element Add to List
 Description  Submission  Solutions
 Total Accepted: 101479
 Total Submissions: 279841
 Difficulty: Medium
 Contributors: Admin
 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 click to show spoilers.
 */
public class FindPeakElement {

    // 显示过于简单的题目一般会用二分法解决
    // 41.15%
    // 除非测试用例特别多,要不然beats 值很可能上一把提交 1% 下一把提交就 90%
    public int findPeakElement(int[] nums) {
        int lo=0,hi=nums.length-1;
        int len=nums.length;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(mid==len-1||nums[mid]<nums[mid+1])lo=mid+1;
            else hi=mid;
        }
        return lo;
    }
}
