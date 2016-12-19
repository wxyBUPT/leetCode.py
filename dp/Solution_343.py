#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
343. Integer Break   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 32652
Total Submissions: 73140
Difficulty: Medium
Contributors: Admin
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

Show Hint
'''

class Solution(object):

    # 50.78%
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 2:
            return 1
        dp = [0] * (n + 1)
        dp[1] = 1
        dp[2] = 2
        for i in range(3,n+1):
            half = i / 2
            i_max = i-1
            for j in range(1,half + 1):
                i_max = max(max(dp[j],j) * max(dp[i-j],i-j) , i_max)
            dp[i] = i_max
        return dp[n]

    # 传说只要把数字分成33333就行了
    # 84.51%
    def on_integerBreak(self, n):
        if n == 2:
            return 1
        if n == 3:
            return 2
        product = 1
        while n > 4:
            product *= 3
            n -= 3
        product *= n
        return product




