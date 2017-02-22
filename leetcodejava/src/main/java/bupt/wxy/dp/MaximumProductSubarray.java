package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 1/12/17.
 152. Maximum Product Subarray
 Difficulty: Medium

 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 Subscribe to see which companies asked this question
 */

/**
 * 本题使用二维数组dp能够解决,但是时间复杂度是On*n
 * 本题目的正确解决方式是使用一维数组
 */
public class MaximumProductSubarray {

    // 14.01% 4ms
    public int maxProduct(int[] nums) {
        if(nums.length==0)return 0;

        // 有here 的变量均代表包括当前值
        int maxpre=nums[0];
        int minpre=nums[0];
        int res=nums[0];
        int max,min;
        for(int i=1;i<nums.length;i++){
            max=Math.max(Math.max(maxpre*nums[i],minpre*nums[i]),nums[i]);
            min=Math.min(Math.min(maxpre*nums[i],minpre*nums[i]),nums[i]);
            res=Math.max(res,max);
            maxpre=max;
            minpre=min;
        }
        return res;

    }
}
