package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 1/4/17.
 213. House Robber II
 Total Accepted: 46059
 Total Submissions: 139797
 Difficulty: Medium
 Contributors: Admin
 Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile,
 the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber_II {

    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==0)return 0;
        int[] dp1=new int[nums.length+1];
        int[] dp2=new int[nums.length+1];
        dp2[1]=nums[0];
        for(int i=2;i<nums.length+1;i++){
            dp1[i]=Math.max(dp1[i-2]+nums[i-1], dp1[i-1]);
            dp2[i]=Math.max(dp2[i-2]+nums[i-1],dp2[i-1]);
        }
        return Math.max(dp1[nums.length],dp2[nums.length-1]);
    }

    public int rob2(int[] nums){
        if(nums.length==1)return nums[0];
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }

    int rob(int[] nums, int lo, int hi){
        int include=0,exclude=0;
        for(int j=lo;j<=hi;j++){
            int i=include,e=exclude;
            include=e+nums[j];
            exclude=Math.max(e,i);
        }
        return Math.max(include,exclude);
    }
}
