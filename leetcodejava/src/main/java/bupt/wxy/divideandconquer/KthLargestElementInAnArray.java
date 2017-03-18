package main.java.bupt.wxy.divideandconquer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiyuanbupt on 3/12/17.
 215. Kth Largest Element in an Array
 Difficulty: Medium
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class KthLargestElementInAnArray {

    // 41.06%
    // 使用快排空间复杂度更好一点
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, nums.length-k);
    }

    int quickSort(int[] nums, int lo, int hi, int k){
        int i=lo, j=hi, pivot=nums[hi];
        while (i<j){
            if(nums[i++]>pivot)swap(nums,--i,--j);
        }
        swap(nums, i, hi);
        if(i==k)return nums[i];
        else if(i<k)return quickSort(nums, i+1, hi, k);
        else return quickSort(nums, lo, i-1, k);
    }

    void swap(int[] a, int i, int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
