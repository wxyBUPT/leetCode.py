#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
78. Subsets   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 132749
Total Submissions: 365386
Difficulty: Medium
Contributors: Admin
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
'''

class Solution(object):

    # 57.08% 在正太分布区间
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        if len(nums)==1:
            return [[],[nums[0]]]
        aftersets = self.subsets(nums[1:])
        for set in aftersets:
            res.append([[nums[0],] + set])
            res.append(set)
        return res
