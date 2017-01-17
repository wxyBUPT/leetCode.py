package main.java.bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 1/15/17.
 154. Find Minimum in Rotated Sorted Array II   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 68496
 Total Submissions: 189272
 Difficulty: Hard
 Contributors: Admin
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int lo=0,hi=nums.length-1;

        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            // 下面这种情况最小的位置肯定在mid右面
            if(nums[mid]>nums[hi])lo=mid+1;
            else if(nums[mid]<nums[hi]){
                hi=mid;
            }
            else hi--;
        }
        return nums[lo];
    }
}
