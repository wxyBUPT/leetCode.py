#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
162. Find Peak Element   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 93549
Total Submissions: 262486
Difficulty: Medium
Contributors: Admin
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
'''

class Solution(object):

    # 57.98%
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in range(1, len(nums)):
            if nums[i] < nums[i-1]:
                return i-1
        return len(nums)-1

    # 51.46%
    def findPeakElementb(self, nums):
        i = 0
        j = len(nums)-1
        while i<j:
            mid = (i+j)/2
            mid1 = mid+1
            if(nums[mid]<nums[mid1]):
                i=mid1
            else:
                j=mid
        return i
