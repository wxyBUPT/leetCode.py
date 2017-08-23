package bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 1/9/17.
 209. Minimum Size Subarray Sum
 Given an array of n positive integers and a positive integer s,
 find the minimal length of a contiguous subarray of which the sum ≥ s.
 If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution,
 try coding another solution of which the time complexity is O(n log n).
 */

/**
 * 有两种方法,一种是twopoint,另外一种是binarysearch
 * binarysearch在binarysearch 中
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums){
        if(nums.length==0)return 0;
        long sum=0;
        int i=0,j=0,res=Integer.MAX_VALUE;
        while (j<nums.length){
            sum+=nums[j++];
            while (sum>=s){
                res=Integer.min(res,j-i);
                sum-=nums[i++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
