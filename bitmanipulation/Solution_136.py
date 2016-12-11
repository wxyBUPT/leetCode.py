#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
# Create at $(date +"%Y-%m-%d")

'''

136. Single Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 178196
Total Submissions: 339430
Difficulty: Easy
Contributors: Admin
Given an array of integers, every element appears twice except for one. Find that single one.

'''

class Solution(object):

    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        for num in nums:
            res ^= num
        return res
