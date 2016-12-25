#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
35. Search Insert Position   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 136022
Total Submissions: 350087
Difficulty: Medium
Contributors: Admin
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

'''

class Solution(object):

    # 46.61%
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start = 0
        end = len(nums)
        while start < end:
            mid = (start+end)//2
            if nums[mid] < target:
                start = mid+1
            else:
                end = mid
        return start
