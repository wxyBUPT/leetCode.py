package bupt.wxy.twopoint;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 1/3/17.
 16. 3Sum Closest
 Difficulty: Medium
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len=nums.length;
        int diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<len-2;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int j=i+1,k=len-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target)return target;
                if(Math.abs(sum-target)<diff){
                    res=sum;
                    diff=Math.abs(sum-target);
                }
                if(sum>target)k--;
                else j++;
            }
        }
        return res;
    }
}
