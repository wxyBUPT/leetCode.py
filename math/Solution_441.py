#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
441. Arranging Coins   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 9522
Total Submissions: 26376
Difficulty: Easy
Contributors: Admin
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
'''


class Solution(object):

    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """
        sum = 0
        row = 0
        while sum < n:
            # row, sum = row + 1, sum + row + 1
            row += 1
            sum += row

        return row if sum == n else row - 1
