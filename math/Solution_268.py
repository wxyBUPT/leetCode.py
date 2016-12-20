#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
# Create at $(date +"%Y-%m-%d")

'''
268. Missing Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 83442
Total Submissions: 192600
Difficulty: Medium
Contributors: Admin
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

'''

class Solution(object):

    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        nums_sum = 0
        for num in nums:
            nums_sum += num
        return n * (n + 1 ) / 2 - nums_sum
