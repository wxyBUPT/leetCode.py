#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
46. Permutations   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 136211
Total Submissions: 339970
Difficulty: Medium
Contributors: Admin
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
'''

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        self.backtracking(nums, [], res)
        return res

    def backtracking(self, remain, curr, res):
        if not remain:
            res.append(curr[:])
            return
        for i in range(len(remain)):
            x = remain[i]
            curr.append(x)
            rest = remain[:i]+remain[i+1:]
            self.backtracking(rest, curr, res)
            curr.pop()

    def stefanPochmann(self, nums):
        return [[n]+p for i, n in enumerate(nums) for p in self.permute(nums[:i]+nums[i+1:])] or [[]]

