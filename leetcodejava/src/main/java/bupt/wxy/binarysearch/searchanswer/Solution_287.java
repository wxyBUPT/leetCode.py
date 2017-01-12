package main.java.bupt.wxy.binarysearch.searchanswer;

/**
 * Created by xiyuanbupt on 1/12/17.
 287. Find the Duplicate Number   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 50901
 Total Submissions: 121837
 Difficulty: Hard
 Contributors: Admin
 Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

 */

/**
 * 如果没有最后一个条件, 使用 On 遍历, index 设成负值, 根据一些条件即可得到结果
 * 题目很明显要二分答案
 */
public class Solution_287 {

    // 50.03% 5ms 难得的一次bugfree, bugfree比较增强信息, 以后要多锻炼bugfree能力
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        int lo=1;
        int hi=n+1;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;

            if(getCount(nums,mid)<=mid)lo=mid+1;
            else hi=mid;
        }

        return lo;
    }

    // 获得数组中小于等于target的个数
    int getCount(int[] nums, int target){
        int res=0;
        for(int num:nums)
            if(num<=target)res++;
        return res;
    }

    // 本题还可以变为求环路开始位置的问题, 有超过两个点可以到达重复的点
    // 但是一直没有想明白如果从环内开始怎么办
    // 60.71%
    int find(int[] nums){
        if(nums.length>1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
