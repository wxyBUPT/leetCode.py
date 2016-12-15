#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
342. Power of Four   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 48047
Total Submissions: 129314
Difficulty: Easy
Contributors: Admin
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Credits:
Special thanks to @yukuairoy for adding this problem and creating all test cases.
'''

class Solution(object):

    # 60.96%
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        return num > 0 and (num & (num - 1)) == 0 and (num & int('0x55555555',16) == num)
