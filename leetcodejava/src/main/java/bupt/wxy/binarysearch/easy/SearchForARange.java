package bupt.wxy.binarysearch.easy;

/**
 * Created by xiyuanbupt on 1/8/17.
 34. Search for a Range
 Difficulty: Medium

 Given an array of integers sorted in ascending order,
 find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */

/**
 * 寻找左右插入点的问题
 */
public class SearchForARange {

    // 共同的特定都是使得low=mid+1;
    public int[] searchRange(int[] nums, int target) {
        int lo,hi;
        int left,right;
        // 寻找左插入点
        lo=0;hi=nums.length;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<target)lo=mid+1;
            else hi=mid;
        }
        left=lo;
        int[] notfound={-1,-1};
        if(left==nums.length||nums[left]!=target)return notfound;
        lo=0;hi=nums.length;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>target)hi=mid;
            else lo=mid+1;
        }
        int[] find={left,lo-1};
        return find;
    }
}
