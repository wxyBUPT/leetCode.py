package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 1/13/17.
 303. Range Sum Query - Immutable
 Total Accepted: 55400
 Total Submissions: 211234
 Difficulty: Easy
 Contributors: Admin
 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 */
public class NumArray {

    long[] dp;

    public NumArray(int[] nums) {
        dp=new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            dp[i+1]=dp[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return (int)(dp[j+1]-dp[i]);
    }
}
