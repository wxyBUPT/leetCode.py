#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
1. Two Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 373739
Total Submissions: 1275586
Difficulty: Easy
Contributors: Admin
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
'''

class Solution(object):

    # 88.26%
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        num_index = {}
        for i in range(len(nums)):
            if num_index.has_key(target - nums[i]):
                return [num_index[target - nums[i]], i]
            else:
                num_index[nums[i]] = i
        return [0, 0 ]
