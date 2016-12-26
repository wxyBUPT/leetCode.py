#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
64. Minimum Path Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 94933
Total Submissions: 256313
Difficulty: Medium
Contributors: Admin
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
'''

class Solution(object):

    # 1.00%
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0
        row = len(grid)
        col = len(grid[0])
        dp = [[0 for _ in xrange(col)] for _ in xrange(row)]
        # 使用下面的赋值会出错，不知道问题出现在哪里
        # dp = [[0]*col]*row
        dp[0][0] = grid[0][0]
        for i in range(1, row):
            dp[i][0] = dp[i-1][0]+grid[i][0]
        for i in range(1,col):
            dp[0][i] = dp[0][i-1] + grid[0][i]
        for i in range(1, row):
            for j in range(1, col):
                dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        return dp[row-1][col-1]

    # 76.53%
    def minPathSumAdd(self, grid):
        if not grid:
            return
        r, c = len(grid), len(grid[0])
        cur = [0]*c
        cur[0]=grid[0][0]
        for i in xrange(1, c):
            cur[i] = cur[i-1] + grid[0][i]
        for i in xrange(1,r):
            cur[0] += grid[i][0]
            for j in xrange(1,c):
                cur[j]=min(cur[j-1],cur[j])+grid[i][j]
        return cur[-1]

