#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''

89. Gray Code   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 77339
Total Submissions: 197530
Difficulty: Medium
Contributors: Admin
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
'''

class Solution(object):

    # 63.48% 和bt没有关系
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        res = []
        end = 1 << n
        for i in range(end):
            res.append(i ^ i>>1)
        return res

    # 83.46%
    def grayCodes(self, n):

        result = [0]
        for i in range(n):
            curCount = len(result)
            while curCount:
                curCount -= 1
                curNum = result[curCount]
                curNum += 1<<i
                result.append(curNum)
        return result

