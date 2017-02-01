package main.java.bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 1/9/17.
 209. Minimum Size Subarray Sum
 Total Accepted: 65188
 Total Submissions: 228514
 Difficulty: Medium
 Contributors: Admin
 Given an array of n positive integers and a positive integer s,
 find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
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

    // 下面算法是自己想出来的但是有点麻烦
    public int minSubArrayLenMore(int s, int[] nums) {
        if(nums.length==0)return 0;
        int i=0,j=1;
        int res=Integer.MAX_VALUE;
        long sum=nums[0];
        while (j<nums.length){
            if(sum>=s){
                res=Math.min(res,j-i);
                sum-=nums[i++];
            }
            else {
                sum+=nums[j++];
            }
        }
        // 如果后面的那个数非常大
        while (sum>=s){
            res=Math.min(res,j-i);
            sum-=nums[i++];
        }
        return res<Integer.MAX_VALUE?res:0;
    }
}
