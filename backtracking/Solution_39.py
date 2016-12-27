#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
39. Combination Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 130676
Total Submissions: 368192
Difficulty: Medium
Contributors: Admin
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]
'''

class Solution(object):

    def w(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        for num in candidates:
            if num == target:
                res.append([num])
            if target - num > 0:
                sub_target = self.combinationSum(candidates, target-num)
                res += map(lambda x:[num,] + x, sub_target)
        return res

    # 58.02%
    def combinationSum(self, candidates, target):
        return self.backtracking(candidates, target, 0)

    def backtracking(self, candidates, target, start):
        res = []
        for i in range(start, len(candidates)):
            if target == candidates[i]:
                res.append([candidates[i]])
            if target>candidates[i]:
                sub_target = self.backtracking(candidates, target-candidates[i], i)
                res += map(lambda x:[candidates[i], ] + x, sub_target)
        return res

    # 77.79%
    def combinationWithOutCreate(self, candidates, target):
        res = []
        self.withoutCreate(candidates, target, res, [], 0)
        return res

    def withoutCreate(self, candidates, target, res, curr, start):
        for i in range(start, len(candidates)):
            if target == candidates[i]:
                res.append(curr + [target, ])
            if target>candidates[i]:
                curr.append(candidates[i])
                self.withoutCreate(candidates, target-candidates[i], res, curr, i)
                curr.pop()
