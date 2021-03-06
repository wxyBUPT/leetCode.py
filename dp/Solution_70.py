#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
70. Climbing Stairs   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 144677
Total Submissions: 375910
Difficulty: Easy
Contributors: Admin
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
'''

class Solution(object):

    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0] * (n+1)
        dp[0] = 1
        dp[1] = 1
        for i in range(2,n+1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]

    def stefanPochmann(self, n):
        a = b = 1
        for _ in range(n):
            a, b = b, a + b
        return a

