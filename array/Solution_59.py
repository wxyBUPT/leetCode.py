#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import math
'''
59. Spiral Matrix II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 69680
Total Submissions: 184384
Difficulty: Medium
Contributors: Admin
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
'''


class Solution(object):

    # 设置了两个方向标，每次转向都有特定的规律
    # 另外判断是否超过可以用取余数来判断是否有数
    # 71.86%
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        A = [[0]*n for _ in range(n)]
        i, j, di, dj = 0, 0, 0, 1
        for k in range(n*n):
            A[i][j] = k+1
            if A[(i+di)%n][(j+dj)%n]:
                di, dj = dj, -di
            i+=di
            j+=dj
        return A


if __name__ == "__main__":
    sl = Solution()
    sl.generateMatrix(10)
