#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''

191. Number of 1 Bits   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 126786
Total Submissions: 330273
Difficulty: Easy
Contributors: Admin
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
'''

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        return bin(n&0xFFFFFFFF).count('1')