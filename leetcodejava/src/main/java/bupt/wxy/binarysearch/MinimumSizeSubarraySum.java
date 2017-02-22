package main.java.bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 1/10/17.
 209. Minimum Size Subarray Sum

 Difficulty: Medium

 Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
 If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */

/**
 * 相当于查找左右插入点
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        int[] sums=new int[nums.length+1];
        for(int i=1;i<sums.length;i++){
            sums[i]=nums[i-1]+sums[i-1];
        }
        int minLen=Integer.MAX_VALUE;
        // 对每一个sum寻找左插入点
        for(int i=0;i<sums.length;i++){
            int end=binarySearch(sums,i+1,sums.length,sums[i]+s);
            // 后续不能再大了
            if(end==sums.length)break;
            if(end-i<minLen)minLen=end-i;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }

    // 寻找左插入位置
    int binarySearch(int[] sums, int lo, int hi, int target){
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(sums[mid]<target)lo=mid+1;
            else hi=mid;
        }
        return lo;
    }

    public static void main(String[] args){
        MinimumSizeSubarraySum sl=new MinimumSizeSubarraySum();
        int[] sums={1,2,2,2,3};
        int i=sl.binarySearch(sums,0,5,2);
        System.out.println(i);
    }
}
