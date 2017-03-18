package main.java.bupt.wxy.binarysearchans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xiyuanbupt on 3/9/17.
 410. Split Array Largest Sum
 Difficulty: Hard

 Given an array which consists of non-negative integers and an integer m,
 you can split the array into m non-empty continuous subarrays.
 Write an algorithm to minimize the largest sum among these m subarrays.

 Note:
 If n is the length of array, assume the following constraints are satisfied:

 1 ≤ n ≤ 1000
 1 ≤ m ≤ min(50, n)
 Examples:

 Input:
 nums = [7,2,5,10,8]
 m = 2

 Output:
 18

 Explanation:
 There are four ways to split nums into two subarrays.
 The best way is to split it into [7,2,5] and [10,8],
 where the largest sum among the two subarrays is only 18.
 */

public class SplitArrayLargestSum {

    //69.11%
    public int splitArray(int[] nums, int m) {
        long total=0;
        long max=Integer.MIN_VALUE;
        for(int num:nums){
            total+=num;
            max=Math.max(max, num);
        }

        long lo=max,hi=total;
        while (lo<hi){
            long mid=lo+(hi-lo)/2;
            if(!isValid(nums,mid,m)){
                lo=mid+1;
            }else {
                hi=mid;
            }
        }
        return (int)(lo);
    }

    // 将nums分堆,每一堆的值不大于max,如果堆数大于m不合法
    boolean isValid(int[] nums, long max, int m){
        long curr=0;
        int count=0;
        for(int num:nums){
            curr+=num;
            if(curr>max){
                curr=num;
                count++;
                if(count>=m)return false;
            }
        }
        return true;
    }
}
