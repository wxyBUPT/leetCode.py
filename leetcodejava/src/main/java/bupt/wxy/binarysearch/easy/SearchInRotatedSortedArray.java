package main.java.bupt.wxy.binarysearch.easy;

/**
 * Created by xiyuanbupt on 1/15/17.
 33. Search in Rotated Sorted Array
 Difficulty: Hard

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {

    // 直接比较容易错
    // 首先找到旋转点,然后使用二分查找
    // 二分查找数组最小的位置
    // 之后二分查找
    public int search(int[] nums, int target) {
        int lo=0,hi=nums.length-1;

        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>nums[hi])lo=mid+1;
            else hi=mid;
        }
        // lo即为旋转的开始点
        if(lo<nums.length&&target<=nums[nums.length-1])return search(nums,target, lo,nums.length-1);
        else return search(nums,target,0,lo-1);

    }

    int search(int[] nums, int target, int lo, int hi){
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
}
