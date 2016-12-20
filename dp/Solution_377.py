#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
 377. Combination Sum IV

    Total Accepted: 22172
    Total Submissions: 53433
    Difficulty: Medium
    Contributors: Admin

Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
'''

class Solution(object):

    # 90.31%
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        dp = [0] * (target + 1)
        dp[0] = 1
        for i in range(1, target + 1):
            res = 0
            for num in nums:
                if i - num >= 0:
                    res += dp[i-num]
            dp[i] = res
        return dp[target]

