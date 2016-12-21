#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
96. Unique Binary Search Trees   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 105134
Total Submissions: 265187
Difficulty: Medium
Contributors: Admin
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
'''

class Solution(object):

    # 想到dp因为对于不同的值，应该创建的树都是一样的
    # 看了解题办法，基本上都是那样
    # 73.06%
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [1] * (n+1)
        for i in range(2,n+1):
            dp[i] = 0
            for j in range(1,i+1):
                dp[i] += dp[i-j] * dp[j-1]
        return dp[n]
