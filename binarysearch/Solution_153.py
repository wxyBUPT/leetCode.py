#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
153. Find Minimum in Rotated Sorted Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 125248
Total Submissions: 325561
Difficulty: Medium
Contributors: Admin
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

'''

class Solution(object):

    # 54.11%
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start = 0
        end = len(nums) - 1
        while start < end:
            if nums[start] < nums[end]:
                return nums[start]
            mid = (start + end)//2
            if nums[mid] >= nums[start]:
                start = mid+1
            else:
                end = mid
        return nums[start]
