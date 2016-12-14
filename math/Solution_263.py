#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
263. Ugly Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 83993
Total Submissions: 219476
Difficulty: Easy
Contributors: Admin
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.

'''
class Solution(object):

    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num < 1:
            return False

        for i in 2,3,5:
            while num % i == 0:
                num /= i
        return num ==1

