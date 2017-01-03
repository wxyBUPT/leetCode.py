package main.java.bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 1/3/17.
 26. Remove Duplicates from Sorted Array   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 185996
 Total Submissions: 527959
 Difficulty: Easy
 Contributors: Admin
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

 Subscribe to see which companies asked this question
 */
public class Solution_26 {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int num:nums){
            if(i==0||num>nums[i-1]){
                nums[i++]=num;
            }
        }
        return i;
    }
}
