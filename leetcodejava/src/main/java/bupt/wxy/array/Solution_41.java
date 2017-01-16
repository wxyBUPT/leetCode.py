package main.java.bupt.wxy.array;

/**
 * Created by xiyuanbupt on 1/16/17.
 41. First Missing Positive   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 85421
 Total Submissions: 342367
 Difficulty: Hard
 Contributors: Admin
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */

/**
 * 应该充分利用数组的长度
 */
public class Solution_41 {

    // 46.03%
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;){
            if(nums[i]==i+1||nums[i]<=0||nums[i]>nums.length)i++;
            else if(nums[nums[i]-1]!=nums[i])swap(nums,i,nums[i]-1);
            else i++;
        }
        int i=0;
        while (i<nums.length&&nums[i]==i+1)i++;
        return i+1;
    }

    void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
