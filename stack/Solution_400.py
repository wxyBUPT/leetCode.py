#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''
400. Nth Digit   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 11518
Total Submissions: 37786
Difficulty: Easy
Contributors: Admin
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
'''

class Solution(object):

    # 81.85%
    def findNthDigit(self, n):
        """
        :type n: int
        :rtype: int
        """
        weight = 1
        start = 1
        end = 9
        while n > weight * (end - start + 1):
            n -= weight * (end - start + 1)
            weight += 1
            start *= 10
            end = end * 10 + 9
        # n是从start 到 end 的第n 个数
        if n % weight == 0:
            start += n / weight - 1
            # 返回最后一位
            return n % 10
        else:
            start += n/weight
            return int(str(start)[n%weight - 1])

