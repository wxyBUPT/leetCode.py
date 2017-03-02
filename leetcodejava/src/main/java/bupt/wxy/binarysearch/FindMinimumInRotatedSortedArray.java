package main.java.bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 3/1/17.
 153. Find Minimum in Rotated Sorted Array Add to List
 Description  Submission  Solutions
 Total Accepted: 135435
 Total Submissions: 347595
 Difficulty: Medium
 Contributors: Admin
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.


 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int lo=0,hi=nums.length-1;
        while (lo<hi){
            if(nums[lo]<nums[hi])return nums[lo];
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>=nums[lo])lo=mid+1;
            else hi=mid;
        }

        return nums[lo];
    }
}
