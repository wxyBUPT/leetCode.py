#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
357. Count Numbers with Unique Digits   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 23408
Total Submissions: 52332
Difficulty: Medium
Contributors: Admin
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

Show Hint
'''

class Solution(object):


    def helper(self, n):
        if n < 1 or n > 10:
            raise Exception("Illegal parameter")
        res = 9
        weight = 9
        while n > 1:
            res *= weight
            weight -= 1
            n -= 1
        return res

    # 54.99
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = [0] * 11
        res[0] = 1
        for i in range(1,11):
            res[i] = self.helper(i)
        ans = 0
        for i in range(n+1):
            ans += res[i]
        return ans
