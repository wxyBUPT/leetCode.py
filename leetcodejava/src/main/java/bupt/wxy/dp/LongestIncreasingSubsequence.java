package main.java.bupt.wxy.dp;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 1/17/17.
 300. Longest Increasing Subsequence
 Total Accepted: 60997
 Total Submissions: 163255
 Difficulty: Medium
 Contributors: Admin
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?

 Credits:
 Special thanks to @pbrother for adding this problem and creating all test cases.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0;

        int[] dp=new int[nums.length];
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])max=Math.max(max,1+dp[j]);
            }
            dp[i]=max;
        }
        int res=0;
        for(int i=0;i<dp.length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    // 还有一种binarysearch 的算法
    // 了解算法思想即可
    public int lengthOf(int[] nums){
        int dp[]=new int[nums.length];
        int len=0;
        for(int x:nums){
            int i= Arrays.binarySearch(dp,0,len,x);
            if(x<0)i=-(i+1);
            dp[i]=x;
            if(i==len)len++;
        }
        return len;
    }
}
