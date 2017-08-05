package main.java.bupt.wxy.sort;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 5/14/17.
 581. Shortest Unsorted Continuous Subarray My SubmissionsBack To Contest
 User Accepted: 747
 User Tried: 971
 Total Accepted: 756
 Total Submissions: 2814
 Difficulty: Easy
 Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0,tmp, 0, nums.length);
        Arrays.sort(tmp);
        int i = 0;
        int j = nums.length - 1;
        // 找到第一个不同的位置
        while (i<=j && nums[i]==tmp[i])i++;
        while (i<=j && nums[j]==tmp[j])j--;
        return j-i+1;
    }
}
