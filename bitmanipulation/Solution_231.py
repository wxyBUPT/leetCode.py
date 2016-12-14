#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
231. Power of Two   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 112059
Total Submissions: 286719
Difficulty: Easy
Contributors: Admin
Given an integer, write a function to determine if it is a power of two.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

'''

class Solution(object):

    # 67.01
    # 二的多少次方只有一个bit是1
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return False if n < 0 else not (n & (n-1))
