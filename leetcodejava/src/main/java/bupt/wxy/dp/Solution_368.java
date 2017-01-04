package main.java.bupt.wxy.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/4/17.
 368. Largest Divisible Subset   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 17173
 Total Submissions: 52142
 Difficulty: Medium
 Contributors: Admin
 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)
 Example 2:

 nums: [1,2,4,8]

 Result: [1,2,4,8]
 */
public class Solution_368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==0)return new ArrayList<>();
        Arrays.sort(nums);
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=1;i<nums.length;i++){
            dp[i+1]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    dp[i+1]=Math.max(dp[j+1]+1,dp[i+1]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int index = findMaxPoint(dp)-1;
        List<Integer> res=new ArrayList<>(dp[index+1]);
        res.add(nums[index]);
        int i=index-1;
        while (i>=0){
            if(nums[index]%nums[i]==0&&dp[i+1]+1==dp[index+1]){
                index=i;
                res.add(nums[index]);
            }
            i--;
        }
        return res;
    }

    int findMaxPoint(int[] nums){
        int index =0;
        for(int i=1;i<nums.length;i++){
            index=nums[i]>nums[index]?i:index;
        }
        return index;
    }

    public static void main(String[] args){
        Solution_368 sl=new Solution_368();
        int[] test = {1,2,4,8};
        sl.largestDivisibleSubset(test);
    }
}
